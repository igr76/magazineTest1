package com.example.springSecurity.sequrity.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
/**
 * Сущность организаций
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "organization")
public class Organization {
    /**   Наименование организации     */
    @Id
    @Column(name = "name")
    String name;
    /**   Описание организации    */
    @Column(name = "title")
    String title;
    /**   Логотип организации     */
    @Column(name = "logotipe")
    String logotipe;
    /**   Товары организации     */
    @ElementCollection
    @CollectionTable(name = "product_list_of_reviews", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "list_if_productO")
    ArrayList<String>  product;
    /** Статус организации  */
    @Column(name = "status")
    boolean status;

}
