package com.example.springSecurity.sequrity.DTO;

import com.example.springSecurity.sequrity.Entity.Discount;
import lombok.*;
import lombok.experimental.FieldDefaults;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDTO {


    /** Id Объявления
     * @param id  */

    Integer id;
    String name;
    Integer author;

    /** Описание Объявления
     * @param description  */
    @Column(name = "description")
    String description;
    /** Стоимость Объявления
     * @param price  */
    @Column(name = "organization")
    String organization;
    /** Стоимость Объявления
     * @param price  */
    @Column(name = "price")
    Integer price;

    Integer quantity;
    Discount discount;
    Categories categories;
    ArrayList<String> reviews;
    ArrayList<String> keyword;
    ArrayList<Integer> specificstions;
    ArrayList<Integer> estimation;
}
