package com.example.springSecurity.sequrity.Service.Impl;

import com.example.springSecurity.sequrity.DTO.NewPassword;
import com.example.springSecurity.sequrity.DTO.UserDTO;
import com.example.springSecurity.sequrity.Entity.Users;
import com.example.springSecurity.sequrity.Mapper.UserMapper;
import com.example.springSecurity.sequrity.Repositories.UserRepository;
import com.example.springSecurity.sequrity.Service.UserService;
import com.example.springSecurity.sequrity.exeption.ElemNotFound;
import com.example.springSecurity.sequrity.loger.FormLogInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import static java.nio.file.StandardOpenOption.CREATE_NEW;

/**
 * Сервис пользователей
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Value("${image.user.dir.path}")
    private String userPhotoDir;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    /**
     * Получить данные пользователя
     */
    @Override
    public UserDTO getUser(Authentication authentication) {
        log.info(FormLogInfo.getInfo());
        String nameEmail = authentication.getName();
        Users user = findEntityByEmail(nameEmail);
        return userMapper.toDTO(user);
    }

    /**
     * Обновить данные пользователя
     */
    @Override
    public UserDTO updateUser(UserDTO newUserDto, Authentication authentication) {
        log.info(FormLogInfo.getInfo());

        String nameEmail = authentication.getName();
        Users user = findEntityByEmail(nameEmail);
        int id = user.getId();

        Users oldUser = findById(id);

        oldUser.setEmail(user.getEmail());
        oldUser.setProduct(user.getProduct());
        oldUser.setUserName(newUserDto.getUserName());
        oldUser.setBalance(newUserDto.getBalance());


           oldUser.setImage(user.getImage());
        userRepository.save(oldUser);

        return userMapper.toDTO(oldUser);
    }

    /**
     * Установить пароль пользователя
     */
    @Override
    public NewPassword setPassword(NewPassword newPassword) {
        log.info(FormLogInfo.getInfo());
        return null;
    }

    /**
     * загрузить аватарку пользователя
     */
    @Override
    public void updateUserImage(MultipartFile image, Authentication authentication) {
        log.info(FormLogInfo.getInfo());

        String nameEmail = authentication.getName();
        Users userEntity = findEntityByEmail(nameEmail);
        String linkToGetImage = "/users" + "/" + userEntity.getId();
        Path filePath = Path.of(userPhotoDir,
                Objects.requireNonNull(String.valueOf(userEntity.getId())));

        if(userEntity.getImage() != null){
            try {
                Files.deleteIfExists(filePath);
                userEntity.setImage(null);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }


        try {
            Files.createDirectories(filePath.getParent());
            Files.deleteIfExists(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (InputStream is = image.getInputStream();
             OutputStream os = Files.newOutputStream(filePath, CREATE_NEW);
             BufferedInputStream bis = new BufferedInputStream(is, 1024);
             BufferedOutputStream bos = new BufferedOutputStream(os, 1024)) {

            bis.transferTo(bos);

            userEntity.setImage(linkToGetImage);
            userRepository.save(userEntity);

        } catch (Exception e) {
            log.info("Ошибка сохранения файла");
        }

    }

    /**
     * получить фото пользователя
     *
     * @return фото конвертированная в массив байтов
     */
    public byte[] getPhotoById(Integer id) {
        String linkToGetImage = "user_photo_dir/" + id;
        byte[] bytes;
        try {
            bytes = Files.readAllBytes(Paths.get(linkToGetImage));
        } catch (IOException e) {
            log.info(FormLogInfo.getCatch());
            throw new RuntimeException(e);
        }
        return bytes;
    }

    /**
     * найти пользователя по id
     *
     * @param id id пользователя
     * @return пользователь
     */
    private Users findById(int id) {
        log.info(FormLogInfo.getInfo());
        return userRepository.findById(id).orElseThrow(ElemNotFound::new);
    }

    /**
     * найти пользователя по email - логину
     *
     * @param email email - логину пользователя
     * @return пользователь
     */
    private Users findEntityByEmail(String email) {
        log.info(FormLogInfo.getInfo());
        return userRepository.findByEmail(email).get();
    }


}