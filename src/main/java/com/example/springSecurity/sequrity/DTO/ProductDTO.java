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
    Role categories;
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
