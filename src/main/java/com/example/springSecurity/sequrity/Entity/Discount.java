package com.example.springSecurity.sequrity.Entity;

import com.example.springSecurity.sequrity.DTO.Categories;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "discount")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categories", nullable = false)
    Categories categories;
    Integer volume;
    /**Дата завершения скидки
     * @param createdAt  */
    @Column(name = "created_ds")
    LocalDateTime createdDs;

}
