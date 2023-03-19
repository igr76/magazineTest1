package com.example.springSecurity.sequrity.Entity;

import com.example.springSecurity.sequrity.DTO.Categories;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "productHistory")
public class ProductHistory {

    /** Id Объявления
     * @param id  */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Integer id;
    Integer author;
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
    Discount discounts;
    Categories categories;
    ArrayList<String> reviews;
    ArrayList<String> keyword;
    ArrayList<Integer> specificstions;
    ArrayList<Integer> estimation;



}
