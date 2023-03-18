package com.example.springSecurity.sequrity.Mapper;

import com.example.springSecurity.sequrity.DTO.UserDTO;
import com.example.springSecurity.sequrity.Entity.Users;
import org.mapstruct.Mapper;
import org.springframework.security.core.userdetails.User;

@Mapper
public interface UserMapper {
    Users toEntity(UserDTO userDTO);
    UserDTO toDTO(Users user);
}
