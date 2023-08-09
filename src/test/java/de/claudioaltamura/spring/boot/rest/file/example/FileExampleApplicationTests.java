package de.claudioaltamura.spring.boot.rest.file.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FileExampleApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;
	@Test
	public void shouldUploadFile() throws Exception {
//		final var resource = Paths.get("src","test","resources", "first.txt");
//
//		final var headers = new HttpHeaders();
//		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
//		final MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
//		body.add("file", resource);
//		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
//		final var serverUrl = "http://localhost:"  + port + "/upload-file/";
//		final var restTemplate = new RestTemplate();
//		ResponseEntity<FileMetaInfo> response = restTemplate.postForEntity(serverUrl, requestEntity, FileMetaInfo.class);
//
//		assertThat(response.getStatusCode()).isEqualTo(201);
	}

}
