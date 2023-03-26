package com.example.springSecurity.sequrity.Controller;

import com.example.springSecurity.sequrity.DTO.NewPassword;
import com.example.springSecurity.sequrity.DTO.UserDTO;
import com.example.springSecurity.sequrity.Service.UserService;
import com.example.springSecurity.sequrity.exeption.AgentInitializationException;
import com.example.springSecurity.sequrity.loger.FormLogInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;

@RequestMapping("/users")
@Slf4j
@CrossOrigin(value = "http://localhost:3000")
@Tag(name = "Пользователи")
@RestController
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Получить пользователя")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = @Content(
                            array = @ArraySchema(schema = @Schema(implementation = UserDTO.class)))
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
    @GetMapping(value = "/me")
    public ResponseEntity<UserDTO> getUser(Authentication authentication) {
        log.info(FormLogInfo.getInfo());
        return ResponseEntity.ok(userService.getUser(authentication));
    }

    @Operation(summary = "Обновить пользователя")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = @Content(
                            array = @ArraySchema(schema = @Schema(implementation = UserDTO.class)))
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
    @PatchMapping(value = "/me")
    public ResponseEntity<UserDTO> updateUser(
            @RequestBody
            @NotBlank(message = "updateUser не должен быть пустым") UserDTO userDto, Authentication authentication) throws AgentInitializationException {
        log.info(FormLogInfo.getInfo());
        return ResponseEntity.ok(userService.updateUser(userDto, authentication));
    }

//    @Operation(summary = "Обновить изображение пользователя")
//    @ApiResponses({
//            @ApiResponse(
//                    responseCode = "200",
//                    description = "OK",
//                    content = @Content(
//                            array = @ArraySchema())
//            ),
//            @ApiResponse(
//                    responseCode = "404",
//                    description = "Not Found",
//                    content = @Content(schema = @Schema())
//            )
//    })
//    @PatchMapping(value = "/me/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<?> updateUserImage(@RequestParam MultipartFile image,
//                                             Authentication authentication) {
//        log.info(FormLogInfo.getInfo());
//        userService.updateUserImage(image, authentication);
//        return ResponseEntity.ok().build();
//    }

//
//    @Operation(summary = "Получить аватарку юзера")
//    @ApiResponses({
//            @ApiResponse(
//                    responseCode = "200",
//                    description = "OK"
//            ),
//            @ApiResponse(
//                    responseCode = "401",
//                    description = "Unauthorized"
//            ),
//            @ApiResponse(
//                    responseCode = "403",
//                    description = "Forbidden"
//            ),
//            @ApiResponse(
//                    responseCode = "404",
//                    description = "Not Found"
//            )
//    })
//    @GetMapping(value = "{id}", produces = MediaType.IMAGE_PNG_VALUE)
//    public ResponseEntity<byte[]> getUserImage(@PathVariable(value = "id") Integer id) {
//        log.info(FormLogInfo.getInfo());
//        return ResponseEntity.ok(userService.getPhotoById(id));
//    }



}