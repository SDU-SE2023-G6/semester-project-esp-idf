package org.example.helloweb.web;

import java.io.IOException;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.*;
import java.nio.file.DirectoryStream.Filter;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileStoreAttributeView;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.nio.file.spi.FileSystemProvider;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InMemoryFileSystemProvider extends FileSystemProvider {
    private final Map<URI, InMemoryFileSystem> fileSystems = new HashMap<>();

    @Override
    public String getScheme() {
        return "in-memory";
    }

    @Override
    public FileSystem newFileSystem(URI uri, Map<String, ?> env) throws IOException {
        synchronized (fileSystems) {
            InMemoryFileSystem fs = new InMemoryFileSystem();
            fileSystems.put(uri, fs);
            return fs;
        }
    }

    @Override
    public FileSystem getFileSystem(URI uri) {
        synchronized (fileSystems) {
            return fileSystems.get(uri);
        }
    }

    @Override
    public Path getPath(URI uri) {
        return getFileSystem(uri).getPath(uri.getPath());
    }

    @Override
    public FileSystem newFileSystem(Path path, Map<String, ?> env) throws IOException {
        throw new UnsupportedOperationException();
    }

    private static class InMemoryFileSystem extends FileSystem {
        private final InMemoryFileSystemProvider provider;
        private final InMemoryFileStore fileStore;

        public InMemoryFileSystem() {
            this.provider = new InMemoryFileSystemProvider();
            this.fileStore = new InMemoryFileStore();
        }

        @Override
        public FileSystemProvider provider() {
            return provider;
        }

        @Override
        public void close() throws IOException {
            // No need to close in-memory file system
        }

        @Override
        public boolean isOpen() {
            return true; // In-memory file system is always open
        }

        @Override
        public boolean isReadOnly() {
            return false; // In-memory file system is not read-only
        }

        @Override
        public String getSeparator() {
            return "/"; // Using "/" as separator for in-memory file system
        }

        @Override
        public Iterable<Path> getRootDirectories() {
            return () -> Stream.of(fileStore.getRootDirectory()).iterator();
        }

        @Override
        public Iterable<FileStore> getFileStores() {
            return Collections.singleton(fileStore);
        }

        @Override
        public Set<String> supportedFileAttributeViews() {
            return Collections.emptySet(); // No specific file attributes supported
        }

        @Override
        public PathMatcher getPathMatcher(String syntaxAndPattern) {
            throw new UnsupportedOperationException("Path matcher not supported in in-memory file system");
        }

        @Override
        public UserPrincipalLookupService getUserPrincipalLookupService() {
            throw new UnsupportedOperationException("User principal lookup service not supported in in-memory file system");
        }

        @Override
        public WatchService newWatchService() throws IOException {
            throw new UnsupportedOperationException("Watch service not supported in in-memory file system");
        }

        public SeekableByteChannel newByteChannel(Path path, Set<? extends OpenOption> options, FileAttribute<?>... attrs) throws IOException {
            return fileStore.newByteChannel(path, options, attrs);
        }

        public void createDirectory(Path dir, FileAttribute<?>... attrs) throws IOException {
            fileStore.createDirectory(dir, attrs);
        }

        @Override
        public Path getPath(String first, String... more) {
        	String joinedPath = Stream.concat(Stream.of(first), Arrays.stream(more))
                    .collect(Collectors.joining("/"));
		return Paths.get(joinedPath);
        }
    }

    private static class InMemoryFileStore extends FileStore {
        private final Path rootDirectory;

        public InMemoryFileStore() {
            this.rootDirectory = Paths.get("/");
        }

        @Override
        public String name() {
            return "in-memory"; // File store name
        }

        @Override
        public String type() {
            return "in-memory"; // File store type
        }

        @Override
        public boolean isReadOnly() {
            return false; // In-memory file store is not read-only
        }

        @Override
        public long getTotalSpace() throws IOException {
            return Long.MAX_VALUE; // Unlimited space for in-memory file store
        }

        @Override
        public long getUsableSpace() throws IOException {
            return Long.MAX_VALUE; // Usable space equals total space in in-memory file store
        }

        @Override
        public long getUnallocatedSpace() throws IOException {
            return Long.MAX_VALUE; // Unallocated space equals total space in in-memory file store
        }

        @Override
        public boolean supportsFileAttributeView(Class<? extends FileAttributeView> type) {
            return false; // No specific file attribute views supported
        }

        @Override
        public boolean supportsFileAttributeView(String name) {
            return false; // No specific file attribute views supported
        }

        @Override
        public <V extends FileStoreAttributeView> V getFileStoreAttributeView(Class<V> type) {
            return null; // No specific file store attribute views
        }

        @Override
        public Object getAttribute(String attribute) throws IOException {
            return null; // No specific attributes supported
        }

        public Path getRootDirectory() {
            return rootDirectory;
        }

        public SeekableByteChannel newByteChannel(Path path, Set<? extends OpenOption> options, FileAttribute<?>... attrs) throws IOException {
            return new InMemorySeekableByteChannel();
        }

        public void createDirectory(Path dir, FileAttribute<?>... attrs) throws IOException {
            if (Files.exists(dir)) {
                throw new FileAlreadyExistsException("Directory already exists: " + dir);
            }
            Files.createDirectory(dir, attrs);
        }

        private static class InMemorySeekableByteChannel implements SeekableByteChannel {
            private byte[] data = new byte[0];
            private int position = 0;
            private boolean open = true;

            @Override
            public int read(ByteBuffer dst) throws IOException {
                int remaining = data.length - position;
                if (remaining <= 0) {
                    return -1;
                }
                int toRead = Math.min(dst.remaining(), remaining);
                dst.put(data, position, toRead);
                position += toRead;
                return toRead;
            }

            @Override
            public int write(ByteBuffer src) throws IOException {
                int remaining = src.remaining();
                byte[] newData = new byte[data.length + remaining];
                System.arraycopy(data, 0, newData, 0, position);
                src.get(newData, position, remaining);
                position += remaining;
                data = newData;
                return remaining;
            }

            @Override
            public long position() throws IOException {
                return position;
            }

            @Override
            public SeekableByteChannel position(long newPosition) throws IOException {
                if (newPosition < 0 || newPosition > data.length) {
                    throw new IllegalArgumentException("Invalid position");
                }
                position = (int) newPosition;
                return this;
            }

            @Override
            public long size() throws IOException {
                return data.length;
            }

            @Override
            public SeekableByteChannel truncate(long size) throws IOException {
                if (size < 0 || size > data.length) {
                    throw new IllegalArgumentException("Invalid size");
                }
                byte[] newData = new byte[(int) size];
                System.arraycopy(data, 0, newData, 0, (int) size);
                data = newData;
                if (position > size) {
                    position = (int) size;
                }
                return this;
            }

            @Override
            public boolean isOpen() {
                return open;
            }

            @Override
            public void close() throws IOException {
                open = false;
            }


        }
    }

    @Override
    public SeekableByteChannel newByteChannel(Path path, Set<? extends OpenOption> options, FileAttribute<?>... attrs)
            throws IOException {
        return getFileSystem(path.toUri()).provider().newByteChannel(path, options, attrs);
    }

    @Override
    public DirectoryStream<Path> newDirectoryStream(Path dir, Filter<? super Path> filter) throws IOException {
        return Files.newDirectoryStream(dir, filter);
    }

    @Override
    public void createDirectory(Path dir, FileAttribute<?>... attrs) throws IOException {
        getFileSystem(dir.toUri()).provider().createDirectory(dir, attrs);
    }

    @Override
    public void delete(Path path) throws IOException {
        Files.delete(path);
    }

    @Override
    public void copy(Path source, Path target, CopyOption... options) throws IOException {
        Files.copy(source, target, options);
    }

    @Override
    public void move(Path source, Path target, CopyOption... options) throws IOException {
        Files.move(source, target, options);
    }

    @Override
    public boolean isSameFile(Path path, Path path2) throws IOException {
        return Files.isSameFile(path, path2);
    }

    @Override
    public boolean isHidden(Path path) throws IOException {
        return Files.isHidden(path);
    }

    @Override
    public FileStore getFileStore(Path path) throws IOException {
        return Files.getFileStore(path);
    }

    @Override
    public void checkAccess(Path path, AccessMode... modes) throws IOException {
        if (!Files.exists(path)) {
            throw new NoSuchFileException(path.toString());
        }

        for (AccessMode mode : modes) {
            switch (mode) {
                case READ:
                    if (!Files.isReadable(path)) {
                        throw new AccessDeniedException("Read access denied for file: " + path.toString());
                    }
                    break;
                case WRITE:
                    if (!Files.isWritable(path)) {
                        throw new AccessDeniedException("Write access denied for file: " + path.toString());
                    }
                    break;
                case EXECUTE:
                    if (!Files.isExecutable(path)) {
                        throw new AccessDeniedException("Execute access denied for file: " + path.toString());
                    }
                    break;
            }
        }
    }
    @Override
    public <V extends FileAttributeView> V getFileAttributeView(Path path, Class<V> type, LinkOption... options) {
        return Files.getFileAttributeView(path, type, options);
    }

    @Override
    public <A extends BasicFileAttributes> A readAttributes(Path path, Class<A> type, LinkOption... options)
            throws IOException {
        return Files.readAttributes(path, type, options);
    }

    @Override
    public Map<String, Object> readAttributes(Path path, String attributes, LinkOption... options) throws IOException {
        return Files.readAttributes(path, attributes, options);
    }

    @Override
    public void setAttribute(Path path, String attribute, Object value, LinkOption... options) throws IOException {
        Files.setAttribute(path, attribute, value, options);
    }
}



