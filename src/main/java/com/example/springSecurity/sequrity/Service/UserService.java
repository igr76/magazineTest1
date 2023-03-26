package com.example.springSecurity.sequrity.Service;

import com.example.springSecurity.sequrity.DTO.NewPassword;
import com.example.springSecurity.sequrity.DTO.UserDTO;
import com.example.springSecurity.sequrity.exeption.AgentInitializationException;
import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;
/**
 * сервис пользователя
 */
public interface UserService {
    /**
     * получить пользователя
     */
    UserDTO getUser(Authentication authentication);

    /**
     * обновить пользователя
     */
    UserDTO updateUser(UserDTO userDto, Authentication authentication) throws AgentInitializationException;


    /**
     * обновить фото пользователя
     */
//    void updateUserImage(MultipartFile image, Authentication authentication);


    /**
     * получить фото пользователя
     */
//    byte[] getPhotoById(Integer id);
}
