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

    private  UserRepository userRepository;
    private  UserMapper userMapper;
    SequrityServise sequrityServise;
//    @Value("${image.user.dir.path}")
//    private String userPhotoDir;

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
        Users user = userRepository.findByEmail(nameEmail).orElseThrow(ElemNotFound::new);
        if (!sequrityServise.checkIsAdmin(authentication)) {
            if (!(nameEmail.equals(newUserDto.getEmail())||newUserDto.getBalance() == user.getBalance()
                    || newUserDto.getRole() == user.getRole()|| newUserDto.getOrganization() == user.getOrganization())) {
                throw new RuntimeException();
            }
        }

        Users newUser = userMapper.toEntity(newUserDto);
        user.setEmail(newUser.getEmail());
        user.setPassword(newUser.getPassword());
        user.setUserName(newUser.getUserName());
        user.setBalance(newUser.getBalance());
        user.setRole(newUser.getRole());
        user.setOrganization(newUser.getOrganization());


          // user.setImage(user.getImage());
        userRepository.save(user);

        return userMapper.toDTO(user);
    }

    /**
     * загрузить аватарку пользователя
     */
//    @Override
//    public void updateUserImage(MultipartFile image, Authentication authentication) {
//        log.info(FormLogInfo.getInfo());
//
//        String nameEmail = authentication.getName();
//        Users userEntity = findEntityByEmail(nameEmail);
//        String linkToGetImage = "/users" + "/" + userEntity.getId();
//        Path filePath = Path.of(userPhotoDir,
//                Objects.requireNonNull(String.valueOf(userEntity.getId())));
//
////        if(userEntity.getImage() != null){
////            try {
////                Files.deleteIfExists(filePath);
////                userEntity.setImage(null);
////            } catch (IOException e) {
////                throw new RuntimeException(e);
////            }
////
////        }
//
//
//        try {
//            Files.createDirectories(filePath.getParent());
//            Files.deleteIfExists(filePath);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        try (InputStream is = image.getInputStream();
//             OutputStream os = Files.newOutputStream(filePath, CREATE_NEW);
//             BufferedInputStream bis = new BufferedInputStream(is, 1024);
//             BufferedOutputStream bos = new BufferedOutputStream(os, 1024)) {
//
//            bis.transferTo(bos);
//
//          //  userEntity.setImage(linkToGetImage);
//            userRepository.save(userEntity);
//
//        } catch (Exception e) {
//            log.info("Ошибка сохранения файла");
//        }
//
//    }
//
//    /**
//     * получить фото пользователя
//     *
//     * @return фото конвертированная в массив байтов
//     */
//    public byte[] getPhotoById(Integer id) {
//        String linkToGetImage = "user_photo_dir/" + id;
//        byte[] bytes;
//        try {
//            bytes = Files.readAllBytes(Paths.get(linkToGetImage));
//        } catch (IOException e) {
//            log.info(FormLogInfo.getCatch());
//            throw new RuntimeException(e);
//        }
//        return bytes;
//    }


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