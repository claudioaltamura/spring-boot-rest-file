package de.claudioaltamura.spring.boot.rest.file.example.controller;

import de.claudioaltamura.spring.boot.rest.file.example.service.StorageFileNotFoundException;
import de.claudioaltamura.spring.boot.rest.file.example.service.StorageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = FileController.class)
class FileControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StorageService storageService;

    @Test
    void shouldListAllFiles() throws Exception {
        when(this.storageService.loadAll())
                .thenReturn(Stream.of(getTestFile()));

        this.mockMvc.perform(get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].fileName").value("first.txt"))
                .andReturn();
    }

    private Path getTestFile() {
        return Paths.get("src","test","resources", "first.txt");
    }

    @Test
    void shouldDownloadFile() throws Exception {
        final var resource = new ClassPathResource("first.txt");

        when(this.storageService.loadAsResource(resource.getFilename())).thenReturn(resource);

        final var textFile = this.mockMvc.perform(get("/download/{fileName}", resource.getFilename()))
                        .andExpect(status().isOk())
                        .andReturn();

        assertThat(textFile.getResponse().getContentAsString()).isEqualTo( "first");
    }

    @Test
    void should404WhenMissingFile() throws Exception {
        when(this.storageService.loadAsResource("test.txt"))
                .thenThrow(StorageFileNotFoundException.class);

        this.mockMvc.perform(get("/download/test.txt")).andExpect(status().isNotFound());
    }

}