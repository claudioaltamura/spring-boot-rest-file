package de.claudioaltamura.spring.boot.rest.file.example.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * UploadFileRequest
 */

@JsonTypeName("uploadFile_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-08-14T13:23:05.462631+02:00[Europe/Berlin]")
public class UploadFileRequest {

  private org.springframework.core.io.Resource attachment;

  public UploadFileRequest attachment(org.springframework.core.io.Resource attachment) {
    this.attachment = attachment;
    return this;
  }

  /**
   * file to be uploaded
   * @return attachment
  */
  @Valid 
  @Schema(name = "attachment", description = "file to be uploaded", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("attachment")
  public org.springframework.core.io.Resource getAttachment() {
    return attachment;
  }

  public void setAttachment(org.springframework.core.io.Resource attachment) {
    this.attachment = attachment;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UploadFileRequest uploadFileRequest = (UploadFileRequest) o;
    return Objects.equals(this.attachment, uploadFileRequest.attachment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attachment);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UploadFileRequest {\n");
    sb.append("    attachment: ").append(toIndentedString(attachment)).append("\n");
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

