package com.example.springSecurity.sequrity.DTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrganizationDTO {
    /**   Наименование организации     */
    String name;
    /**   Описание организации    */
    String title;
    /**   Логотип организации     */
    String logotipe;
    /**   Товары организации     */
    ArrayList<String>  product;
    /** Статус организации  */
    boolean status;

}
