package de.claudioaltamura.spring.boot.rest.file.example.controller;


import de.claudioaltamura.spring.boot.rest.file.example.model.ApiError;
import de.claudioaltamura.spring.boot.rest.file.example.service.StorageException;
import de.claudioaltamura.spring.boot.rest.file.example.service.StorageFileNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.UUID;

@ControllerAdvice
public class FileControllerExceptionHandler extends ResponseEntityExceptionHandler {

    static ApiError createApiError(String message) {
        final var apiError = new ApiError();

        apiError.setErrorId(UUID.randomUUID().toString());
        apiError.setErrorMessage(message);

        return apiError;
    }

    @ExceptionHandler(StorageException.class)
    public ResponseEntity<ApiError> handleStorageException(StorageException exc) {
        final var apiError = createApiError(exc.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<ApiError> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        final var apiError = createApiError("File does not exist.");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }

}
