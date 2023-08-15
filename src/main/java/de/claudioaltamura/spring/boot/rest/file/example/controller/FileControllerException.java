package de.claudioaltamura.spring.boot.rest.file.example.controller;

public class FileControllerException extends RuntimeException {

  public FileControllerException(String message) {
    super(message);
  }

  public FileControllerException(String message, Throwable cause) {
    super(message, cause);
  }
}
