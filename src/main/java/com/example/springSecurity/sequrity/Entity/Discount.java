package com.example.springSecurity.sequrity.Entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "discount")
public class Discount {
    String product;
    Integer volume;
    /**Дата завершения скидки
     * @param createdAt  */
    @Column(name = "created_ds")
    LocalDateTime createdDs;

}
