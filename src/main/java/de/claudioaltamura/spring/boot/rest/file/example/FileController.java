package de.claudioaltamura.spring.boot.rest.file.example;

import de.claudioaltamura.spring.boot.rest.file.example.api.FileApi;
import de.claudioaltamura.spring.boot.rest.file.example.model.FileMetaInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
public class FileController implements FileApi {

    @Autowired
    private StorageService storageService;

    @Override
    public ResponseEntity<FileMetaInfo> uploadFile(MultipartFile attachment) {
        return ResponseEntity.ok(storeFile(attachment));
    }

    private FileMetaInfo storeFile(MultipartFile attachment) {
        final var fileName = storageService.store(attachment);
        log.info("storing file '{}'", fileName);

        final var fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        final var fileMetaInfo =  new FileMetaInfo();
        fileMetaInfo.setFileName(fileName);
        fileMetaInfo.setDownloadUrl(fileDownloadUri);
        fileMetaInfo.setContentType(attachment.getContentType());
        fileMetaInfo.setSize(attachment.getSize());
        return fileMetaInfo;
    }

    @Override
    public ResponseEntity<List<FileMetaInfo>> uploadFiles(List<MultipartFile> attachments) {
        final var fileMetaInfoList = attachments.stream()
                .map(this::storeFile)
                .collect(Collectors.toList());

        return ResponseEntity.ok(fileMetaInfoList);
    }

    private FileMetaInfo buildFileMetaInfo(Path path) {
        final var fileMetaInfo =  new FileMetaInfo();
        try {
            fileMetaInfo.setFileName(path.getFileName().toString());
            fileMetaInfo.setDownloadUrl(ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/downloadFile/")
                    .path(path.getFileName().toString())
                    .toUriString());
            fileMetaInfo.setContentType(Files.probeContentType(path.getFileName()));
            fileMetaInfo.setSize(Files.size(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return fileMetaInfo;
    }

}
