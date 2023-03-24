package com.example.springSecurity.sequrity.Controller;

import com.example.springSecurity.sequrity.DTO.*;
import com.example.springSecurity.sequrity.Service.ProductService;
import com.example.springSecurity.sequrity.loger.FormLogInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.IOException;
import java.util.Collection;

@RestController
@RequestMapping()
@Tag(name = "Товары")
@Slf4j
@CrossOrigin(value = "http://localhost:3000")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "Получить список товаров  ")
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
    @GetMapping("/Products")
    public ResponseEntity<Collection<ProductDTO>> getAllProduct(Categories categories) {
        return ResponseEntity.ok().body(productService.getAllProduct(categories));
    }
    @Operation(summary = "Показать товар")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = @Content(
                            array = @ArraySchema(schema = @Schema(implementation = ProductDTO.class)))
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
    @GetMapping(value = "/product/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable(name = "id")
                                                         @NotBlank(message = "id не должен быть пустым")
                                                         @Min(value = 1, message = "Идентификатор должен быть больше 0")
                                                         @Parameter(description = "Идентификатор комментария",
                                                                 example = "1") int id) {
        log.info(FormLogInfo.getInfo());
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @Operation(summary = " Обновляет товар ")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = @Content(
                            array = @ArraySchema(schema = @Schema(implementation = ProductDTO.class)))
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
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable(value = "id") Integer id,
                                              @RequestBody @Valid ProductDTO productDTO,
                                              Authentication authentication) {
        log.info(FormLogInfo.getInfo());
        return ResponseEntity.ok(productService.updateProduct(id,productDTO,authentication));
    }
    @Operation(summary = "Добавляем товар")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content =
                    @Content(
                            array = @ArraySchema(schema = @Schema(implementation = ProductDTO.class)))
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
    public ResponseEntity<ProductDTO> addProduct( @RequestBody @Valid ProductDTO productDTO,
                                                  Authentication authentication) throws IOException {
        log.info(FormLogInfo.getInfo());
        ProductDTO productDTO1 = productService.addProduct(productDTO,authentication);
        return ResponseEntity.ok(productDTO1);
    }
    @Operation(summary = "Удаляет товар ")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "No Content"
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized"
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Forbidden"
            )
    })
    @DeleteMapping(value = "/product/{id}")
    public void deleteProduct(@PathVariable(name = "id")
                          @NotBlank(message = "id не должен быть пустым")
                          @Min(value = 1, message = "Идентификатор должен быть больше 0")
                          @Parameter(description = "Идентификатор объявления",
                                  example = "1") int id, Authentication authentication) {
        productService.deleteProduct(id, authentication);
    }

    @Operation(summary = "Получить уведомление ")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = {
                            @Content(
                                    schema = @Schema())
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found",
                    content = {@Content(array = @ArraySchema(schema = @Schema()))}
            )
    })
    @GetMapping("/product/notification/{id}")
    public ResponseEntity<Collection<NotificationDTO>> getNotification(@PathVariable(name = "id")
                                                                           @NotBlank(message = "id не должен быть пустым")
                                                                           @Min(value = 1, message = "Идентификатор должен быть больше 0")
                                                                           @Parameter(description = "Идентификатор объявления",
                                                                                   example = "1") int id,@RequestBody @Valid NotificationDTO notificationDTO,
                                                                       Authentication authentication){
        return ResponseEntity.ok().body(productService.getNotification(id,notificationDTO));
    }
    @Operation(summary = "Добавляем уведомление")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content =
                    @Content(
                            array = @ArraySchema(schema = @Schema(implementation = ProductDTO.class)))
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
    @PostMapping(value = "/product/notification/{id}")
    void addNotification( @PathVariable(name = "id")
                          @NotBlank(message = "id не должен быть пустым")
                          @Min(value = 1, message = "Идентификатор должен быть больше 0")
                          @Parameter(description = "Идентификатор объявления",
                                  example = "1") int id,@RequestBody @Valid NotificationDTO notificationDTO    ) throws IOException {
        log.info(FormLogInfo.getInfo());
        productService.addNotification(id,notificationDTO);

    }
    @Operation(summary = " Купить товар ")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "CommentDTO added",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = ProductDTO.class)))
                    }),
    })
    @PatchMapping(value = "/product/buy/{id}")
    void buyProduct( @PathVariable(name = "id")
                     @NotBlank(message = "id не должен быть пустым")
                     @Min(value = 1, message = "Идентификатор должен быть больше 0")
                     @Parameter(description = "Идентификатор объявления",
                             example = "1") int id,@RequestBody @Valid ProductDTO productDTO
            ,Authentication authentication    ) throws IOException {
        log.info(FormLogInfo.getInfo());
        productService.buyProduct( id, productDTO, authentication);
    }
    @Operation(summary = "Получить историю товара")
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
    @GetMapping(value = "/history")
    public ResponseEntity<Collection<ProductDTOHistory>> getProductDTOHistoryById( @PathVariable(name = "id")
                                                                                       @NotBlank(message = "id не должен быть пустым")
                                                                                       @Min(value = 1, message = "Идентификатор должен быть больше 0")
                                                                                       @Parameter(description = "Идентификатор объявления",
                                                                                               example = "1") int id,Authentication authentication) {
        log.info(FormLogInfo.getInfo());
        return ResponseEntity.ok(productService.getProductDTOHistoryById(id,authentication));
    }
    @Operation(summary = "Возврат продукта")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "CommentDTO added",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = ProductDTO.class)))
                    }),
    })
    @PatchMapping(value = "/refund")
    void refundProduct( @PathVariable(name = "id")
                     @NotBlank(message = "id не должен быть пустым")
                     @Min(value = 1, message = "Идентификатор должен быть больше 0")
                     @Parameter(description = "Идентификатор объявления",
                             example = "1") int id,@RequestBody @Valid ProductDTO productDTO
            ,Authentication authentication    ) throws IOException {
        log.info(FormLogInfo.getInfo());
        productService.refundProduct( id,  authentication);
    }
    @Operation(summary = "Оставить отзыв  и оценку")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "CommentDTO added",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = ProductDTO.class)))
                    }),
    })
    @PatchMapping(value = "/reviews")
    public ResponseEntity<ProductDTO> toLeaveReviews( @PathVariable(name = "id")
                        @NotBlank(message = "id не должен быть пустым")
                        @Min(value = 1, message = "Идентификатор должен быть больше 0")
                        @Parameter(description = "Идентификатор объявления",
                                example = "1") int id,Authentication authentication ,String reviewsDTO,int estimationDTO  ) throws IOException {
        log.info(FormLogInfo.getInfo());
       return ResponseEntity.ok(productService.toLeaveReviews( id,  authentication,reviewsDTO,estimationDTO));
    }
    @Operation(summary = " Написать уведомление")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "CommentDTO added",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = ProductDTO.class)))
                    }),
    })
    @PatchMapping(value = "/notification")
    void writeNotification( @RequestBody @Valid NotificationDTO notificationDTO  ) throws IOException {
        log.info(FormLogInfo.getInfo());
        productService.writeNotification( notificationDTO);
    }
}
