package com.example.springSecurity.sequrity.Controller;

import com.example.springSecurity.sequrity.DTO.Categories;
import com.example.springSecurity.sequrity.DTO.OrganizationDTO;
import com.example.springSecurity.sequrity.DTO.ProductDTO;
import com.example.springSecurity.sequrity.DTO.UserDTO;
import com.example.springSecurity.sequrity.Service.OrganizationService;
import com.example.springSecurity.sequrity.loger.FormLogInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Collection;
@RestController
@RequestMapping()
@Tag(name = "Организации")
@Slf4j
@CrossOrigin(value = "http://localhost:3000")
public class OrganizationController {
    OrganizationService organizationService;



    @Operation(summary = "Получить список организаций  ")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = {
                            @Content(
                                    schema = @Schema( ))
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found",
                    content = {@Content(array = @ArraySchema(schema = @Schema()))}
            )
    })
    @GetMapping("/organizations")
    public ResponseEntity<Collection<OrganizationDTO>> getOrganization() {
        return ResponseEntity.ok().body(organizationService.getOrganization());
    }
    @Operation(summary = "Добавляем организацию ")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content =
                    @Content(
                            array = @ArraySchema(schema = @Schema(implementation = OrganizationDTO.class)))
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized",
                    content = @Content(schema = @Schema())
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Forbidden",
                    content = @Content(schema = @Schema())
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found",
                    content = @Content(schema = @Schema())
            )
    })
    @PostMapping(value = "/product")
    public ResponseEntity<OrganizationDTO> addOrganization( @RequestBody @Valid OrganizationDTO organizationDTO,Authentication authentication) throws IOException {
        log.info(FormLogInfo.getInfo());
        return ResponseEntity.ok(organizationService.addOrganization(organizationDTO,authentication ));
    }
    @Operation(summary = " Изменить организацию  ")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = @Content(
                            array = @ArraySchema(schema = @Schema(implementation = OrganizationDTO.class)))
            ),
            @ApiResponse(
                    responseCode = "204",
                    description = "No Content",
                    content = @Content(schema = @Schema())
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized",
                    content = @Content(schema = @Schema())
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Forbidden",
                    content = @Content(schema = @Schema())
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found",
                    content = @Content(schema = @Schema())
            )
    })
    @PatchMapping(value = "/product/{id}")
    public ResponseEntity<OrganizationDTO> updateOrganization(@PathVariable(value = "id") Integer id,
                                                    @RequestBody @Valid OrganizationDTO organizationDTO,
                                                    Authentication authentication) {
        log.info(FormLogInfo.getInfo());
        return ResponseEntity.ok(organizationService.updateOrganization(id,organizationDTO,authentication));
    }
}
