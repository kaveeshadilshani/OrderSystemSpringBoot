package com.hellokoding.springboot.bean;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileService {
    private static final String FILE_DIRECTORY = System.getProperty("user.dir");


    public void storeFile(MultipartFile file) throws IOException {
        System.out.println(FILE_DIRECTORY);
        Path filePath = Paths.get(FILE_DIRECTORY + "/" + file.getOriginalFilename());

        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
    }

    public void storeFileJms(MultipartFile file) throws IOException {
        System.out.println(FILE_DIRECTORY);
        Path filePath = Paths.get(FILE_DIRECTORY + "/" + file.getOriginalFilename());
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
    }
}
