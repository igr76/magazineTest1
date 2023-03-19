package com.example.springSecurity.sequrity.mapper;

import com.example.springSecurity.sequrity.DTO.UserDTO;
import com.example.springSecurity.sequrity.Entity.Users;
import com.example.springSecurity.sequrity.Mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class UserMapperTest {

    private UserMapper userMapper;

    @Test
    void testEntityToDTO() {
        Users userEntity = new Users();
        userEntity.setId(1);
        userEntity.setUserName("Иван");
        userEntity.setEmail("ivanov@mail.ru");
        userEntity.setPassword("79876543201");
        userEntity.setImage("/user/1");

        UserDTO userDTO = userMapper.toDTO(userEntity);
        assertNotNull(userDTO);
        assertEquals(userDTO.getUserName(), userEntity.getUserName());
    }

    @Test
    void testDTOToEntity() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1);
        userDTO.setUserName("Иван");
        userDTO.setEmail("ivanov@mail.ru");
        userDTO.setPassword("79876543201");
        userDTO.setImage("/user/1");

        Users userEntity = userMapper.toEntity(userDTO);
        assertNotNull(userEntity);
        assertEquals(userEntity.getUserName(), userDTO.getUserName());
    }
}