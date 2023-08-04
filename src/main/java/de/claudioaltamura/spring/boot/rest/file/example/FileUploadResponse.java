package de.claudioaltamura.spring.boot.rest.file.example;

public record FileUploadResponse (String fileName, String fileDownloadUri, String contentType, long size) {}