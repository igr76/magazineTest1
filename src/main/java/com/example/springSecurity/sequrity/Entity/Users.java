package com.example.springSecurity.sequrity.Entity;

import com.example.springSecurity.sequrity.DTO.Role;
import com.example.springSecurity.sequrity.Service.Impl.SequrityServise;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.aspectj.weaver.ast.Not;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class Users {
    SequrityServise sequrityServise;
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
    /** Продавец товара
     * @param organization  */
    @Column(name = "organization")
    String organization;



}
