package org.example.helloweb.web;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.generator.GeneratorContext;
import org.eclipse.xtext.generator.GeneratorDelegate;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.util.DisposableRegistry;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.example.helloweb.HelloWebStandaloneSetup;

import com.google.inject.Injector;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "CodeGenerationServlet", urlPatterns = "/generate-code")
public class CodeGenerationServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Read the DSL content from the request
        String dslContent = request.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);

        // Debug print to show the DSL content
        System.out.println("DSL Content: " + dslContent);

        // Generate code from the DSL content and get the zip file
        byte[] zipFile = generateZipFileFromDSL(dslContent);

        // Debug print to show the size of the generated zip file
        System.out.println("Generated Zip File Size: " + zipFile.length + " bytes");

        // Set the response headers
        response.setContentType("application/zip");
        response.setContentLength(zipFile.length);
        response.setHeader("Content-Disposition", "attachment; filename=\"generated_code.zip\"");

        // Debug print to indicate that the response headers are being set
        System.out.println("Setting response headers...");

        // Write the zip file to the response
        response.getOutputStream().write(zipFile);

        // Debug print to indicate that the zip file has been written to the response
        System.out.println("Zip file written to response.");
    }

    private byte[] generateZipFileFromDSL(String dslContent) throws IOException {
        // Debug print to indicate that the method has been called
        System.out.println("Generating zip file from DSL content...");

        // Create a disposable registry to manage resources
        DisposableRegistry disposableRegistry = new DisposableRegistry();

        // Initialize Xtext setup and injector
        System.out.println("Initializing Xtext setup and injector...");
        Injector injector = new HelloWebStandaloneSetup().createInjectorAndDoEMFRegistration();
        ResourceSet rs = injector.getInstance(ResourceSet.class);

        // Debug print to show the DSL content
        System.out.println("DSL Content: " + dslContent);

        // Create resources from DSL content
        System.out.println("Creating resources from DSL content...");
        Resource resource = rs.createResource(URI.createURI("dummy:/example.helloweb"));
        try {
            resource.load(new ByteArrayInputStream(dslContent.getBytes()), null);
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0]; // Return empty byte array if loading fails
        }

        // Validate resources
        System.out.println("Validating resources...");
        IResourceValidator validator = injector.getInstance(IResourceValidator.class);
        List<Issue> issues = validator.validate(resource, CheckMode.ALL, null);
        for (Issue issue : issues) {
            System.out.println(issue);
        }

        // Generate code for resources
        System.out.println("Generating code for resources...");
        GeneratorDelegate generator = injector.getInstance(GeneratorDelegate.class);
        JavaIoFileSystemAccess fsa = injector.getInstance(JavaIoFileSystemAccess.class);

        // Generate code using in-memory file system
        String randomUUID = UUID.randomUUID().toString();
        fsa.setOutputPath("in-memory:/src-gen-code/"+randomUUID);
        GeneratorContext context = new GeneratorContext();
        context.setCancelIndicator(null);
        generator.generate(resource, fsa, context);

        // Collect generated files from in-memory file system
        System.out.println("Collecting generated files...");
        
        byte[] zipFile = generateZipFileFromInMemoryFiles("in-memory:/src-gen-code/"+randomUUID);
        
     // Delete the folder if it exists
        File outputFolder = new File("in-memory:/src-gen-code/"+randomUUID);
        if (outputFolder.exists()) {
            deleteFolder(outputFolder);
        }
        
        // Create and return zip file containing generated code
        return zipFile;
    }


 // Method to delete a folder recursively
    private void deleteFolder(File folder) {
        if (folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    deleteFolder(file);
                }
            }
        }
        folder.delete();
    }

    private byte[] generateZipFileFromInMemoryFiles(String inMemoryPath) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream)) {
            Path path = Paths.get(inMemoryPath);
            Files.walk(path)
                 .filter(Files::isRegularFile)
                 .forEach(filePath -> {
                     try {
                         String relativePath = path.relativize(filePath).toString();
                         zipOutputStream.putNextEntry(new ZipEntry(relativePath));
                         Files.copy(filePath, zipOutputStream);
                         zipOutputStream.closeEntry();
                     } catch (IOException e) {
                         e.printStackTrace();
                     }
                 });
        }
        return outputStream.toByteArray();
    }


}
