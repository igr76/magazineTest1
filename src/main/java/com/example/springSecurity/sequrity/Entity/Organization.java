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
    String name;
    String title;
    String logotipe;
    ArrayList<String>  product;

}
