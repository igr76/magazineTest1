package com.example.springSecurity.sequrity.Entity;

import lombok.*;

import javax.persistence.Table;
import java.util.ArrayList;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "organization")
public class Organization {
    /**   Наименование организации     */
    String name;
    /**   Описание организации    */
    String title;
    /**   Логотип организации     */
    String logotipe;
    /**   Товары организации     */
    ArrayList<String>  product;

}
