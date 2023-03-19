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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    /** Id Товара
     * @param id  */
            Integer id;
    /** Наименование товара
     * @param name  */
    @Column(name = "organization")
    String name;
    /** Продавец товара
     * @param organization  */
    @Column(name = "organization")
    String organization;

    /** Описание товара
     * @param description  */
    @Column(name = "description")
    String description;
    /** Стоимость Объявления
     * @param price  */
    @Column(name = "price")
    Integer price;
    /** Количество товара
     * @param quantity  */
    @Column(name = "quantity")
    Integer quantity;
    /** Скидка на товар
     * @param discount  */
    @Column(name = "discount")
    Discount discount;
    /** Категория товара
     * @param categories  */
    @Column(name = "categories")
    Categories categories;
    /** Отзывы на товар
     * @param reviews  */
    @Column(name = "reviews")
    ArrayList<String> reviews;
    /** Ключевые слова
     * @param keyword  */
    @Column(name = "keyword")
    ArrayList<String> keyword;
    /** Характеристика товара
     * @param specificstions  */
    @Column(name = "specificstions")
    ArrayList<Integer> specificstions;
    /** Оценки товара
     * @param estimation  */
    @Column(name = "estimation")
    ArrayList<Integer> estimation;



}
