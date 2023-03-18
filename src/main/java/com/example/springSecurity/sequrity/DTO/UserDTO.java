package com.example.springSecurity.sequrity.DTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDTO {
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
