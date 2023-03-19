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
    /** Категория  скидки       */
            Categories categories;
    /** Размер скидки       */
    Integer volume;
    /**Дата завершения скидки       */
    @Column(name = "created_ds")
    LocalDateTime createdDs;

}
