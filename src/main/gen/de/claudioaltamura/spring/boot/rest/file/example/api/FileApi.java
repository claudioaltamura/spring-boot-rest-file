/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.5.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package de.claudioaltamura.spring.boot.rest.file.example.api;

import de.claudioaltamura.spring.boot.rest.file.example.model.ApiError;
import de.claudioaltamura.spring.boot.rest.file.example.model.FileMetaInfo;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-08-14T13:23:05.462631+02:00[Europe/Berlin]")
@Validated
@Tag(name = "file", description = "API for managing files")
public interface FileApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /download/{fileName} : Downloads a file.
     *
     * @param fileName file name (required)
     * @return file (status code 200)
     *         or Generic error (status code 500)
     */
    @Operation(
        operationId = "downloadFile",
        summary = "Downloads a file.",
        tags = { "file" },
        responses = {
            @ApiResponse(responseCode = "200", description = "file", content = {
                @Content(mediaType = "application/octet-stream", schema = @Schema(implementation = byte[].class)),
                @Content(mediaType = "application/json", schema = @Schema(implementation = byte[].class))
            }),
            @ApiResponse(responseCode = "500", description = "Generic error", content = {
                @Content(mediaType = "application/octet-stream", schema = @Schema(implementation = ApiError.class)),
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/download/{fileName}",
        produces = { "application/octet-stream", "application/json" }
    )
    default ResponseEntity<byte[]> downloadFile(
        @Parameter(name = "fileName", description = "file name", required = true, in = ParameterIn.PATH) @PathVariable("fileName") String fileName
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET / : List all files.
     *
     * @return listed files (status code 200)
     *         or Generic error (status code 500)
     */
    @Operation(
        operationId = "listFiles",
        summary = "List all files.",
        tags = { "file" },
        responses = {
            @ApiResponse(responseCode = "200", description = "listed files", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = FileMetaInfo.class)))
            }),
            @ApiResponse(responseCode = "500", description = "Generic error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/",
        produces = { "application/json" }
    )
    default ResponseEntity<List<FileMetaInfo>> listFiles(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"fileName\" : \"test.pdf\", \"size\" : 5, \"downloadUrl\" : \"http://localhost/download/test.pdf\", \"contentType\" : \"application/pdf\" }, { \"fileName\" : \"test.pdf\", \"size\" : 5, \"downloadUrl\" : \"http://localhost/download/test.pdf\", \"contentType\" : \"application/pdf\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /upload-file : Uploads a file.
     *
     * @param attachment file to be uploaded (optional)
     * @return uploaded file (status code 200)
     *         or Generic error (status code 500)
     */
    @Operation(
        operationId = "uploadFile",
        summary = "Uploads a file.",
        tags = { "file" },
        responses = {
            @ApiResponse(responseCode = "200", description = "uploaded file", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = FileMetaInfo.class))
            }),
            @ApiResponse(responseCode = "500", description = "Generic error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/upload-file",
        produces = { "application/json" },
        consumes = { "multipart/form-data" }
    )
    default ResponseEntity<FileMetaInfo> uploadFile(
        @Parameter(name = "attachment", description = "file to be uploaded") @RequestPart(value = "attachment", required = false) MultipartFile attachment
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"fileName\" : \"test.pdf\", \"size\" : 5, \"downloadUrl\" : \"http://localhost/download/test.pdf\", \"contentType\" : \"application/pdf\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /upload-files : Uploads multiple files.
     *
     * @param attachments files to be uploaded (optional)
     * @return uploaded files (status code 200)
     *         or Generic error (status code 500)
     */
    @Operation(
        operationId = "uploadFiles",
        summary = "Uploads multiple files.",
        tags = { "file" },
        responses = {
            @ApiResponse(responseCode = "200", description = "uploaded files", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = FileMetaInfo.class)))
            }),
            @ApiResponse(responseCode = "500", description = "Generic error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/upload-files",
        produces = { "application/json" },
        consumes = { "multipart/form-data" }
    )
    default ResponseEntity<List<FileMetaInfo>> uploadFiles(
        @Parameter(name = "attachments", description = "files to be uploaded") @RequestPart(value = "attachments", required = false) List<MultipartFile> attachments
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"fileName\" : \"test.pdf\", \"size\" : 5, \"downloadUrl\" : \"http://localhost/download/test.pdf\", \"contentType\" : \"application/pdf\" }, { \"fileName\" : \"test.pdf\", \"size\" : 5, \"downloadUrl\" : \"http://localhost/download/test.pdf\", \"contentType\" : \"application/pdf\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
