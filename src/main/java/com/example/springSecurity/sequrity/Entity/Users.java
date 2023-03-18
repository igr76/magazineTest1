package com.example.springSecurity.sequrity.Entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class Users {
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

}
