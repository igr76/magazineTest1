package com.example.springSecurity.sequrity.Entity;

import lombok.*;

import javax.persistence.Column;
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
    @Column(name = "name")
    String name;
    /**   Описание организации    */
    @Column(name = "title")
    String title;
    /**   Логотип организации     */
    @Column(name = "logotipe")
    String logotipe;
    /**   Товары организации     */
    @Column(name = "product")
    ArrayList<String>  product;
    /** Статус организации  */
    @Column(name = "status")
    boolean status;

}
