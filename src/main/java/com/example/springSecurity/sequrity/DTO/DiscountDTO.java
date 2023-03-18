package com.example.springSecurity.sequrity.DTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DiscountDTO {
    String product;
    Integer volume;
    /**Дата завершения скидки
     * @param createdAt  */
    @Column(name = "created_ds")
    LocalDateTime createdDs;

}
