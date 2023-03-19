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
public class ProductDTOHistory {
    /** Id Товара
     * @param id  */
    Integer id;
    /** Наименование товара
     * @param name  */
    String name;
    /** Продавец товара
     * @param organization  */
    String organization;

    /** Описание товара
     * @param description  */

    String description;
    /** Стоимость Объявления
     * @param price  */
    Integer price;
    /** Количество товара
     * @param quantity  */
    Integer quantity;
    /** Скидка на товар
     * @param discount  */
    Discount discount;
    /** Категория товара
     * @param categories  */
    Categories categories;
    /** Отзывы на товар
     * @param reviews  */
    ArrayList<String> reviews;
    /** Ключевые слова
     * @param keyword  */
    ArrayList<String> keyword;
    /** Характеристика товара
     * @param specificstions  */
    ArrayList<Integer> specificstions;
    /** Оценки товара
     * @param estimation  */
    ArrayList<Integer> estimation;
}
