package de.claudioaltamura.spring.boot.rest.file.example.controller;

import de.claudioaltamura.spring.boot.rest.file.example.service.StorageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = FileController.class)
class FileControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StorageService storageService;

    @Test
    public void shouldListAllFiles() throws Exception {
        given(this.storageService.loadAll())
                .willReturn(Stream.of(getTestFile()));

        this.mockMvc.perform(get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].fileName").value("first.txt"))
                .andReturn();

        then(this.storageService.loadAll()).should().
    }

    private Path getTestFile() {
        return Paths.get("src","test","resources", "first.txt");
    }

}