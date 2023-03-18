package com.example.springSecurity.sequrity.Entity;

import lombok.*;

import javax.persistence.Table;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "discount")
public class Discount {
    String product;
    Integer volume;
    String time;

}
