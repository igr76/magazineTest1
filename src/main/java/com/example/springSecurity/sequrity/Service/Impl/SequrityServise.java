package com.example.springSecurity.sequrity.Service.Impl;

import com.example.springSecurity.sequrity.DTO.Role;
import com.example.springSecurity.sequrity.Entity.Users;
import com.example.springSecurity.sequrity.Repositories.ProductRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class SequrityServise {
    ProductRepository productRepository;

    /** Проверка пользователя на авторство */
    public boolean checkAuthor(int id, Users user) {
        return id == user.getId();
    }
    /** Проверка пользователя на электронную почту */
    public boolean isAuthorAuthenticated(String email, Authentication authentication) {
        return authentication.getName().equals(email) && authentication.isAuthenticated();
    }
    /** Проверка пользователя на роль администратора */
    public boolean isAdmin(Users user) {
        return user.getRole().equals(Role.ADMIN);
    }

    /** Проверка возможности обновления */
    private boolean isUpdateAvailable(Authentication authentication) {
        if (!authentication.isAuthenticated()) {
            return false;
        }
        if (isAdmin(authentication)) {
            return true;
        }
        return false;
    }
    public boolean isAdmin(Authentication authentication) {
        return authentication.isAuthenticated() &&
                authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
}
