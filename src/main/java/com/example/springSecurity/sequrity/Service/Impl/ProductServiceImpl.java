package com.example.springSecurity.sequrity.Service.Impl;

import com.example.springSecurity.sequrity.DTO.Categories;
import com.example.springSecurity.sequrity.DTO.NotificationDTO;
import com.example.springSecurity.sequrity.DTO.ProductDTO;
import com.example.springSecurity.sequrity.DTO.ProductDTOHistory;
import com.example.springSecurity.sequrity.Entity.Notification;
import com.example.springSecurity.sequrity.Entity.ProductHistory;
import com.example.springSecurity.sequrity.Mapper.NotificationMapper;
import com.example.springSecurity.sequrity.Repositories.NotificationRepository;
import com.example.springSecurity.sequrity.Repositories.ProductHistoryRepository;
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
    ProductHistoryRepository productHistoryRepository;
    Product product;

    @Override
    public Collection<ProductDTO> getAllProduct(Categories categories) {
        log.info(FormLogInfo.getInfo());
        Collection<Product> product = productRepository.findProductByCategories(categories);
        return (Collection<ProductDTO>) productMapper.toDTOList(product);
    }

    @Override
    public ProductDTO getProductById(int id) {
        log.info(FormLogInfo.getInfo());
        Product product = productRepository.findById(id).orElseThrow(ElemNotFound::new);
        return productMapper.toDTO(product);
    }

    @Override
    public ProductDTO updateProduct(int id, ProductDTO productDTO, Authentication authentication) {
        log.info(FormLogInfo.getInfo());
        if (!sequrityServise.checkAuthorEmailAndAdsId(id, authentication) || sequrityServise.checkIsAdmin(authentication)) {
            throw new SecurityAccessException();
        }
        Product product1 = productMapper.toEntity(productDTO);
        return productMapper.toDTO(productRepository.save(product1));
    }

    @Override
    public ProductDTO addProduct(ProductDTO productDTO, Authentication authentication) throws IOException {
        log.info(FormLogInfo.getInfo());

        if (productDTO == null ) {
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
        if (sequrityServise.checkAuthorEmailAndAdsId(id, authentication) || sequrityServise.checkIsAdmin(authentication)) {
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
    public void buyProduct(int id, ProductDTO productDTO,Authentication authentication) throws IOException {
        log.info(FormLogInfo.getInfo());
        if (!sequrityServise.checkAuthorEmailAndAdsId(id, authentication)) {
            throw new SecurityAccessException();
        }
        Product product1 = productRepository.findById(id).orElseThrow(ElemNotFound::new);
        Integer balanse = sequrityServise.getUserByEmail(authentication).getBalance();
        if (balanse - product1.getPrice() >= 0) {
            ProductHistory productHistory1 = productMapper.toHistory(product1);
            productHistoryRepository.save(productHistory1);
            productRepository.deleteById(id);
        }

    }

    @Override
    public Collection<ProductDTOHistory> getProductDTOHistoryById(int id, Authentication authentication) {

        log.info(FormLogInfo.getInfo());
        if (!sequrityServise.checkAuthorEmailAndAdsId(id, authentication)
                || !sequrityServise.isAdmin(authentication)) {
            throw new SecurityAccessException();
        }
        return productMapper.toDTOHistoryList(productHistoryRepository.findAllById(id));
    }

    @Override
    public void refundProduct(int id, Authentication authentication) {
        log.info(FormLogInfo.getInfo());
        if (!sequrityServise.checkAuthorEmailAndAdsId(id, authentication)
                || !sequrityServise.isAdmin(authentication) {
            throw new SecurityAccessException();
        }
        ProductHistory productHistory1 = productHistoryRepository.findById(id).orElseThrow(ElemNotFound::new);
        sequrityServise.getUserByEmail(authentication).getBalance() + productHistory1.getPrice();
        Product product1 = productRepository.findById(id).orElseThrow(ElemNotFound::new);
        Integer balanse = sequrityServise.getUserByEmail(authentication).getBalance();
        if (balanse - product1.getPrice() >= 0) {

            productHistoryRepository.save(productHistory1);
            productRepository.deleteById(id);
        }
    }

}
