package com.example.springSecurity.sequrity.Entity;

import com.example.springSecurity.sequrity.DTO.Role;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class Users {
    /**
     * id пользователя
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Integer id;
    /**
     * Имя пользователя
     */
    @Column(name = "user_name")
    String userName;


    /**
     * почта пользователя
     */
    @Column(name = "email")
    String email;

    /**
     * пароль пользователя
     */
    @Column(name = "password")
    String password;

    /**
     * пароль пользователя
     */
    @Column(name = "password")
    Integer balance;
    /**
     * фото пользователя
     */
    @Column(name = "image")
    String image;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;
    /**
     * Список объявлений пользователя
     */
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    @JsonBackReference
    @ToString.Exclude
    List<Product> product;

}
