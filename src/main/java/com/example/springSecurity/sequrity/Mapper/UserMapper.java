package com.example.springSecurity.sequrity.Mapper;

import com.example.springSecurity.sequrity.DTO.UserDTO;
import org.mapstruct.Mapper;
import org.springframework.security.core.userdetails.User;

@Mapper
public interface UserMapper {
    User toEntity(UserDTO userDTO);
    UserDTO toDTO(User user);
}
