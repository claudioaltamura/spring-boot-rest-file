package de.claudioaltamura.spring.boot.rest.file.example.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * response object for uploaded file
 */

@Schema(name = "FileMetaInfo", description = "response object for uploaded file")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-08-14T13:23:05.462631+02:00[Europe/Berlin]")
public class FileMetaInfo {

  private String fileName;

  private String downloadUrl;

  private String contentType;

  private Long size;

  public FileMetaInfo fileName(String fileName) {
    this.fileName = fileName;
    return this;
  }

  /**
   * file name
   * @return fileName
  */
  
  @Schema(name = "fileName", example = "test.pdf", description = "file name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("fileName")
  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public FileMetaInfo downloadUrl(String downloadUrl) {
    this.downloadUrl = downloadUrl;
    return this;
  }

  /**
   * download url
   * @return downloadUrl
  */
  
  @Schema(name = "downloadUrl", example = "http://localhost/download/test.pdf", description = "download url", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("downloadUrl")
  public String getDownloadUrl() {
    return downloadUrl;
  }

  public void setDownloadUrl(String downloadUrl) {
    this.downloadUrl = downloadUrl;
  }

  public FileMetaInfo contentType(String contentType) {
    this.contentType = contentType;
    return this;
  }

  /**
   * Get contentType
   * @return contentType
  */
  
  @Schema(name = "contentType", example = "application/pdf", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("contentType")
  public String getContentType() {
    return contentType;
  }

  public void setContentType(String contentType) {
    this.contentType = contentType;
  }

  public FileMetaInfo size(Long size) {
    this.size = size;
    return this;
  }

  /**
   * file size in kb
   * @return size
  */
  
  @Schema(name = "size", example = "5", description = "file size in kb", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("size")
  public Long getSize() {
    return size;
  }

  public void setSize(Long size) {
    this.size = size;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FileMetaInfo fileMetaInfo = (FileMetaInfo) o;
    return Objects.equals(this.fileName, fileMetaInfo.fileName) &&
        Objects.equals(this.downloadUrl, fileMetaInfo.downloadUrl) &&
        Objects.equals(this.contentType, fileMetaInfo.contentType) &&
        Objects.equals(this.size, fileMetaInfo.size);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fileName, downloadUrl, contentType, size);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FileMetaInfo {\n");
    sb.append("    fileName: ").append(toIndentedString(fileName)).append("\n");
    sb.append("    downloadUrl: ").append(toIndentedString(downloadUrl)).append("\n");
    sb.append("    contentType: ").append(toIndentedString(contentType)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

