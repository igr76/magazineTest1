package com.example.springSecurity.sequrity.Entity;

import com.example.springSecurity.sequrity.DTO.Role;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.aspectj.weaver.ast.Not;

import javax.persistence.*;
import java.util.List;

@Getter
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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }
}
