package org.example.helloweb.web;

import jakarta.servlet.ServletContextListener;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.nio.file.spi.FileSystemProvider;
import java.util.ServiceLoader;

@WebListener
public class HelloWebContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        InMemoryFileSystemProvider provider = new InMemoryFileSystemProvider();
        ServiceLoader<FileSystemProvider> loader = ServiceLoader.load(FileSystemProvider.class);
        boolean isProviderRegistered = false;
        for (FileSystemProvider existingProvider : loader) {
            if (existingProvider.getScheme().equalsIgnoreCase("in-memory")) {
                isProviderRegistered = true;
                break;
            }
        }
        if (!isProviderRegistered) {
            ServiceLoader<FileSystemProvider> providers = ServiceLoader.load(FileSystemProvider.class);
            providers.forEach(p -> {});
        } else {
            throw new IllegalStateException("In-memory file system provider is already registered");
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        // Clean up resources if needed
    }
}