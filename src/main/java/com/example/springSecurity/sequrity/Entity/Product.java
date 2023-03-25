package com.example.springSecurity.sequrity.Entity;

import antlr.collections.List;
import com.example.springSecurity.sequrity.DTO.Categories;
import com.example.springSecurity.sequrity.DTO.Role;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Objects;
/**
 * Сущность товаров
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    /** Id Товара
     * @param id  */
            Integer id;
    /** Наименование товара
     * @param name  */
    @Column(name = "name")
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
    Integer discount;
    /** Категория товара
     * @param categories  */
    @Column(name = "categories")
    Categories categories;
    /** Отзывы на товар
     * @param reviews  */
    @ElementCollection
    @CollectionTable(name = "product_list_of_reviews", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "list_if_reviews")
    ArrayList<String> reviews;
    /** Ключевые слова
     * @param keyword  */

    @ElementCollection
    @CollectionTable(name = "product_list_of_keyword", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "list_if_keyword")
    ArrayList<String> keyword;
    /** Характеристика товара
     * @param specificstions  */
    @ElementCollection
    @CollectionTable(name = "product_list_of_specificstions", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "list_if_specificstions")
    ArrayList<String> specificstions;
    /** Оценки товара
     * @param estimation  */
    @ElementCollection
    @CollectionTable(name = "product_list_of_estimation", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "list_if_estimation")
    ArrayList<Integer> estimation;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Objects.equals(getId(), product.getId()) && Objects.equals(getName(), product.getName()) && Objects.equals(getOrganization(), product.getOrganization()) && Objects.equals(getDescription(), product.getDescription()) && Objects.equals(getPrice(), product.getPrice()) && Objects.equals(getQuantity(), product.getQuantity()) && Objects.equals(getDiscount(), product.getDiscount()) && getCategories() == product.getCategories() && Objects.equals(getReviews(), product.getReviews()) && Objects.equals(getKeyword(), product.getKeyword()) && Objects.equals(getSpecificstions(), product.getSpecificstions()) && Objects.equals(getEstimation(), product.getEstimation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getOrganization(), getDescription(), getPrice(), getQuantity(), getDiscount(), getCategories(), getReviews(), getKeyword(), getSpecificstions(), getEstimation());
    }
}
