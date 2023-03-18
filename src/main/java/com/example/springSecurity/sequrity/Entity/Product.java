package com.example.springSecurity.sequrity.Entity;

import antlr.collections.List;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product {


    Discount discount;
    String name;
    /** Id Объявления
     * @param id  */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Integer id;

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
