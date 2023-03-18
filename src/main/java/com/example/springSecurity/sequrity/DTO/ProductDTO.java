package com.example.springSecurity.sequrity.DTO;

import com.example.springSecurity.sequrity.Entity.Discount;
import lombok.*;
import lombok.experimental.FieldDefaults;


import javax.persistence.Column;
import java.util.ArrayList;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDTO {
    Discount discount;
    String name;

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
    ArrayList<Discount> discounts;
    ArrayList<String> reviews;
    ArrayList<String> keyword;
    ArrayList<Integer> specificstions;
    ArrayList<Integer> estimation;
}
