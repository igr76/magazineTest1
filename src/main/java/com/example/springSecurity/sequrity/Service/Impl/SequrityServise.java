package com.example.springSecurity.sequrity.Service.Impl;

import com.example.springSecurity.sequrity.DTO.Role;
import com.example.springSecurity.sequrity.Entity.Organization;
import com.example.springSecurity.sequrity.Entity.Product;
import com.example.springSecurity.sequrity.Entity.Users;
import com.example.springSecurity.sequrity.Repositories.OrganizationRepository;
import com.example.springSecurity.sequrity.Repositories.ProductRepository;
import com.example.springSecurity.sequrity.Repositories.UserRepository;
import com.example.springSecurity.sequrity.exeption.ElemNotFound;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class SequrityServise {
    ProductRepository productRepository;
    UserRepository userRepository;
    OrganizationRepository organizationRepository;

    /** Проверка авторства объявления по Authentication */
    public boolean checkAuthorEmailAndAdsId(int id, Authentication authentication) {
        Users user = userRepository.findByEmail(authentication.getName()).orElseThrow(ElemNotFound::new);
        Product adEntity = productRepository.findById(id).orElseThrow(ElemNotFound::new);
        if (checkIsFreeze(authentication)) {
            return false;
        }
        return user.getOrganization() == adEntity.getOrganization();
    }
    /** Проверка пользователя на электронную почту */
    public boolean isAuthorAuthenticated(String email, Authentication authentication) {
        return authentication.getName().equals(email) && authentication.isAuthenticated();
    }
    /** Проверка пользователя на роль администратора */
    public boolean checkIsAdmin( Authentication authentication) {
        Users user = userRepository.findByEmail(authentication.getName()).orElseThrow(ElemNotFound::new);
        return user.getRole().equals(Role.ADMIN);
    }
    public  Users getUserByEmail(Authentication authentication) {
        Users user = userRepository.findByEmail(authentication.getName()).orElseThrow(ElemNotFound::new);
        return user;
    }

    /**
     * Проверка легальности организации
     */
    public boolean checkLegalOrganization(String organization) {
        Organization organization1 = organizationRepository.findByName(organization);
        if (organization1.isStatus()) { return true;
        } else  return false;
    }
    /** Проверка пользователя на наличие организации */
    public boolean checkUserOrganization(Authentication authentication) {
        Users user = userRepository.findByEmail(authentication.getName()).orElseThrow(ElemNotFound::new);
        if (user.getOrganization() == null) {
            return false;
        } else return true;
    }

        /** Проверка пользователя на заморозку */
    public boolean checkIsFreeze( Authentication authentication) {
        Users user = userRepository.findByEmail(authentication.getName()).orElseThrow(ElemNotFound::new);
        return user.getRole().equals(Role.FREEZE);
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
