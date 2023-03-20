package com.example.springSecurity.sequrity.Entity;

import com.example.springSecurity.sequrity.DTO.Categories;
import com.example.springSecurity.sequrity.DTO.Role;
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
    @Column(name = "categories", nullable = false)
    /** Категория  скидки       */
            Role categories;
    /** Размер скидки       */
    @Column(name = "volume")
    Integer volume;
    /**Дата завершения скидки       */
    @Column(name = "created_ds")
    LocalDateTime createdDs;

}
