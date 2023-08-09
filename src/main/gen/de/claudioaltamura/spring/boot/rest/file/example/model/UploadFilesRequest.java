package de.claudioaltamura.spring.boot.rest.file.example.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * UploadFilesRequest
 */

@JsonTypeName("uploadFiles_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-08-09T16:35:14.645904+02:00[Europe/Berlin]")
public class UploadFilesRequest {

  @Valid
  private List<org.springframework.core.io.Resource> attachments;

  public UploadFilesRequest attachments(List<org.springframework.core.io.Resource> attachments) {
    this.attachments = attachments;
    return this;
  }

  public UploadFilesRequest addAttachmentsItem(org.springframework.core.io.Resource attachmentsItem) {
    if (this.attachments == null) {
      this.attachments = new ArrayList<>();
    }
    this.attachments.add(attachmentsItem);
    return this;
  }

  /**
   * files to be uploaded
   * @return attachments
  */
  @Valid @Size(min = 1, max = 10) 
  @Schema(name = "attachments", description = "files to be uploaded", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("attachments")
  public List<org.springframework.core.io.Resource> getAttachments() {
    return attachments;
  }

  public void setAttachments(List<org.springframework.core.io.Resource> attachments) {
    this.attachments = attachments;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UploadFilesRequest uploadFilesRequest = (UploadFilesRequest) o;
    return Objects.equals(this.attachments, uploadFilesRequest.attachments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attachments);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UploadFilesRequest {\n");
    sb.append("    attachments: ").append(toIndentedString(attachments)).append("\n");
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

