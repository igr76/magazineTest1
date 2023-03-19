package com.example.springSecurity.sequrity.Service.Impl;

import com.example.springSecurity.sequrity.DTO.*;
import com.example.springSecurity.sequrity.Entity.Notification;
import com.example.springSecurity.sequrity.Entity.ProductHistory;
import com.example.springSecurity.sequrity.Mapper.NotificationMapper;
import com.example.springSecurity.sequrity.Mapper.UserMapper;
import com.example.springSecurity.sequrity.Repositories.NotificationRepository;
import com.example.springSecurity.sequrity.Repositories.ProductHistoryRepository;
import com.example.springSecurity.sequrity.Repositories.UserRepository;
import com.example.springSecurity.sequrity.exeption.ElemNotFound;
import com.example.springSecurity.sequrity.Entity.Product;
import com.example.springSecurity.sequrity.Mapper.ProductMapper;
import com.example.springSecurity.sequrity.Repositories.ProductRepository;
import com.example.springSecurity.sequrity.exeption.SecurityAccessException;
import com.example.springSecurity.sequrity.loger.FormLogInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
public class ProductServiceImpl implements com.example.springSecurity.sequrity.Service.ProductService {
    ProductRepository productRepository;
    ProductMapper productMapper;
    SequrityServise sequrityServise;
    NotificationRepository notificationRepository;
    NotificationMapper notificationMapper;
    ProductDTOHistory productDTOHistory;
    ProductHistory productHistory;
    UserRepository userRepository;
    UserMapper userMapper;
    ProductDTO productDTO;

    ProductHistoryRepository productHistoryRepository;
    Product product;

    @Override
    public Collection<ProductDTO> getAllProduct(Categories categories) {
        log.info(FormLogInfo.getInfo());
        Collection<Product> product = productRepository.findProductByCategories(categories);
        product.stream()
                .map(e ->e.getOrganization())
                .filter(e -> sequrityServise.checkLegalOrganization(e))
                .collect(Collectors.toList());
        return  productMapper.toDTOList(product);
    }

    @Override
    public ProductDTO getProductById(int id) {
        log.info(FormLogInfo.getInfo());
        Product product = productRepository.findById(id).orElseThrow(ElemNotFound::new);
        if (!sequrityServise.checkLegalOrganization(product.getOrganization())) {
            return null;
        }
        return productMapper.toDTO(product);
    }

    @Override
    public ProductDTO updateProduct(int id, ProductDTO productDTO, Authentication authentication) {
        log.info(FormLogInfo.getInfo());
        if (!sequrityServise.checkAuthorEmailAndAdsId(id, authentication) ||
                !sequrityServise.checkUserOrganization(authentication)||sequrityServise.checkIsAdmin(authentication)) {
            throw new SecurityAccessException();
        }
        Product product1 = productMapper.toEntity(productDTO);
        return productMapper.toDTO(productRepository.save(product1));
    }

    @Override
    public ProductDTO addProduct(ProductDTO productDTO, Authentication authentication) throws IOException {
        log.info(FormLogInfo.getInfo());

        if (productDTO == null || !sequrityServise.checkUserOrganization(authentication)) {
            log.error(FormLogInfo.getException());
            throw new IllegalArgumentException();
        }
        int count = productRepository.findMaxID() +1;
        productDTO.setId(count);
        Product product1 = productMapper.toEntity(productDTO);
        return productMapper.toDTO(productRepository.save(product1));
    }

    @Override
    public void deleteProduct(int id, Authentication authentication) {
        log.info(FormLogInfo.getInfo());
        if (sequrityServise.checkAuthorEmailAndAdsId(id, authentication) ||
                sequrityServise.checkIsAdmin(authentication) || sequrityServise.checkUserOrganization(authentication)) {
            Product product1 = productRepository.findById(id).orElseThrow(ElemNotFound::new);
            productRepository.deleteById(id);
        }else   throw new SecurityAccessException();

    }

    @Override
    public Collection<NotificationDTO> getNotification(int id, NotificationDTO notificationDTO) {
        log.info(FormLogInfo.getInfo());
       return  notificationMapper.toDTONotificationList(notificationRepository.findById(id));
    }

    @Override
    public void addNotification(int id, NotificationDTO notificationDTO) throws IOException {
        log.info(FormLogInfo.getInfo());
        notificationRepository.save(notificationMapper.toEntity(notificationDTO));
         }

    @Override
    public void buyProduct(int id, ProductDTO productDTO,Authentication authentication)  {
        log.info(FormLogInfo.getInfo());
        if (!sequrityServise.checkAuthorEmailAndAdsId(id, authentication)) {
            throw new SecurityAccessException();
        }
        Product product1 = productRepository.findById(id).orElseThrow(ElemNotFound::new);
        Integer balanse = sequrityServise.getUserByEmail(authentication).getBalance();
        if (balanse - product1.getPrice() >= 0) {
            ProductHistory productHistory1 = productMapper.toHistory(product1);
            productHistoryRepository.save(productHistory1);
        }

    }

    @Override
    public Collection<ProductDTOHistory> getProductDTOHistoryById(int id, Authentication authentication) {

        log.info(FormLogInfo.getInfo());
        if (!sequrityServise.checkAuthorEmailAndAdsId(id, authentication)
                || !sequrityServise.isAdmin(authentication)) {
            throw new SecurityAccessException();
        }
        return null; //productMapper.toDTOHistoryList(productHistoryRepository.findAllById(id));
    }

    @Override
    public void refundProduct(int id, Authentication authentication) {
        log.info(FormLogInfo.getInfo());
        if (!sequrityServise.checkAuthorEmailAndAdsId(id, authentication)
                || !sequrityServise.isAdmin(authentication)) {
            throw new SecurityAccessException();
        }
        ProductHistory productHistory1 = productHistoryRepository.findById(id).orElseThrow(ElemNotFound::new);
        UserDTO userDTO = userMapper.toDTO(sequrityServise.getUserByEmail(authentication));
        userDTO.setBalance(userDTO.getBalance() + productHistory1.getPrice());
            userRepository.save(userMapper.toEntity(userDTO));
            productHistoryRepository.deleteById(id);

    }

    @Override
    public ProductDTO toLeaveReviews(int id,Authentication authentication,String reviewsDTO,int estimationDTO) {
        log.info(FormLogInfo.getInfo());
        if (!sequrityServise.checkAuthorEmailAndAdsId(id, authentication)) {
            throw new SecurityAccessException();
        }
        Product product1= productRepository.findById(id).orElseThrow(ElemNotFound::new);
        ProductDTO productDTO1=productMapper.toDTO(product1);
//        productDTO.setReviews(productDTO1.getReviews().add(reviewsDTO));
//        productDTO.setEstimation(productDTO1.getEstimation().add(estimationDTO));
        return productDTO;
    }

    @Override
    public void writeNotification(NotificationDTO notificationDTO) {
        notificationRepository.save(notificationMapper.toEntity(notificationDTO));
    }


}
