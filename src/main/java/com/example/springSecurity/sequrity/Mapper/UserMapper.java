package com.example.springSecurity.sequrity.Mapper;

import com.example.springSecurity.sequrity.DTO.ProductDTO;
import com.example.springSecurity.sequrity.DTO.UserDTO;
import com.example.springSecurity.sequrity.Entity.Product;
import com.example.springSecurity.sequrity.Entity.Users;
import org.mapstruct.Mapper;
import org.springframework.security.core.userdetails.User;
/**
 * маппер для {@link Users} готовый DTO {@link UserDTO}
 */
@Mapper
public interface UserMapper {
    Users toEntity(UserDTO userDTO);
    UserDTO toDTO(Users user);
}
