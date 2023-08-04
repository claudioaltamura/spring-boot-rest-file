package de.claudioaltamura.spring.boot.rest.file.example;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

interface StorageService {
    void init();

    String store(MultipartFile file);

    Path load(String filename);

    Stream<Path> loadAll();

    Resource loadAsResource(String filename);

    void deleteAll();
}
