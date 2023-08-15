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
 * ApiError
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-08-15T17:07:56.208482+02:00[Europe/Berlin]")
public class ApiError {

  private String errorId;

  private String errorMessage;

  public ApiError errorId(String errorId) {
    this.errorId = errorId;
    return this;
  }

  /**
   * error id
   * @return errorId
  */
  @NotNull 
  @Schema(name = "errorId", example = "4711", description = "error id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("errorId")
  public String getErrorId() {
    return errorId;
  }

  public void setErrorId(String errorId) {
    this.errorId = errorId;
  }

  public ApiError errorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
    return this;
  }

  /**
   * error message
   * @return errorMessage
  */
  @NotNull 
  @Schema(name = "errorMessage", example = "Object not found", description = "error message", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("errorMessage")
  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiError apiError = (ApiError) o;
    return Objects.equals(this.errorId, apiError.errorId) &&
        Objects.equals(this.errorMessage, apiError.errorMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(errorId, errorMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiError {\n");
    sb.append("    errorId: ").append(toIndentedString(errorId)).append("\n");
    sb.append("    errorMessage: ").append(toIndentedString(errorMessage)).append("\n");
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

