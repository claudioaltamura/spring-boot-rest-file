package de.claudioaltamura.spring.boot.rest.file.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import de.claudioaltamura.spring.boot.rest.file.example.service.StorageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.multipart.MultipartFile;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FileExampleApplicationTests {

  @Autowired private TestRestTemplate restTemplate;

  @MockBean private StorageService storageService;

  @LocalServerPort private int port;

  @Test
  void shouldUploadFile() {
    final var resource = new ClassPathResource("test.txt");
    final var map = new LinkedMultiValueMap<String, Object>();
    map.add("attachment", resource);

    final ResponseEntity<String> response =
        this.restTemplate.postForEntity("/upload-file", map, String.class);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    assertThat(response.getHeaders().getLocation().toString())
        .startsWith("http://localhost:" + this.port + "/");

    verify(this.storageService).store(any(MultipartFile.class));
  }

  @Test
  void shouldDownloadFile() {
    final var resource = new ClassPathResource("test.txt");
    when(this.storageService.loadAsResource(resource.getFilename())).thenReturn(resource);

    final ResponseEntity<String> response =
        this.restTemplate.getForEntity(
            "/download/{filename}", String.class, resource.getFilename());

    assertThat(response.getStatusCode().value()).isEqualTo(200);
    assertThat(response.getHeaders().getFirst(HttpHeaders.CONTENT_DISPOSITION))
        .isEqualTo("attachment; filename=\"" + resource.getFilename() + "\"");
    assertThat(response.getBody()).isEqualTo("test");

    verify(this.storageService).loadAsResource(resource.getFilename());
  }
}
