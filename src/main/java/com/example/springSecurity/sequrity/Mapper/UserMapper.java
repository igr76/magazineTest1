package com.example.springSecurity.sequrity.Mapper;

import com.example.springSecurity.sequrity.DTO.UserDTO;
import com.example.springSecurity.sequrity.Entity.Users;
import org.mapstruct.Mapper;


/**
 * маппер для {@link Users} готовый DTO {@link UserDTO}
 */

@Mapper(componentModel = "spring")
public interface UserMapper {
    Users toEntity(UserDTO userDTO);
    UserDTO toDTO(Users user);
}
