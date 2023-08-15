package de.claudioaltamura.spring.boot.rest.file.example;

import de.claudioaltamura.spring.boot.rest.file.example.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class FileExampleApplication {

  public static void main(String[] args) {
    SpringApplication.run(FileExampleApplication.class, args);
  }

  @Bean
  CommandLineRunner init(StorageService storageService) {
    return args -> {
      storageService.deleteAll();
      storageService.init();
    };
  }
}
