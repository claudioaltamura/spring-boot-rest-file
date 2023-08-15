package de.claudioaltamura.spring.boot.rest.file.example.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;

class FileStorageServiceTest {

  private final StorageProperties properties = new StorageProperties();
  private FileStorageService service;

  @BeforeEach
  public void init() {
    properties.setLocation("target/files/" + Math.abs(new Random().nextLong()));
    service = new FileStorageService(properties);
    service.init();
  }

  @Test
  void shouldStoreFile() {
    final var fileName =
        service.store(
            new MockMultipartFile(
                "foo", "bar/../foo.txt", MediaType.TEXT_PLAIN_VALUE, "Hello, World".getBytes()));
    assertThat(fileName).isEqualTo("foo.txt");
  }

  @Test
  void shouldLoadResource() throws IOException {
    service.store(
        new MockMultipartFile(
            "foo", "bar/../foo.txt", MediaType.TEXT_PLAIN_VALUE, "Hello, World".getBytes()));

    final var resource = service.loadAsResource("foo.txt");

    assertThat(resource.getContentAsString(StandardCharsets.UTF_8)).isEqualTo("Hello, World");
  }
}
