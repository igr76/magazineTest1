package com.example.springSecurity.sequrity.Entity;

import com.example.springSecurity.sequrity.DTO.Role;
import com.example.springSecurity.sequrity.Service.Impl.SequrityServise;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.aspectj.weaver.ast.Not;

import javax.persistence.*;
import java.util.List;
/**
 * Сущность пользователей
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
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
    @Column(name = "balance")
    Integer balance;
    /**
     * статус пользователя
     */
    @Column(name = "roles")
    @Enumerated(EnumType.STRING)
    Role role;
    /** Продавец товара
     * @param organization  */
    @Column(name = "organization")
    String organization;
    /**
     * фото пользователя
     */
//    @Column(name = "image")
//    String image;

}
