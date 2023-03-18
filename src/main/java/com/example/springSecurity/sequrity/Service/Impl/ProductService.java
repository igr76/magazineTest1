package com.example.springSecurity.sequrity.Service.Impl;

import com.example.springSecurity.sequrity.DTO.ProductDTO;
import com.example.springSecurity.sequrity.exeption.ElemNotFound;
import com.example.springSecurity.sequrity.Entity.Product;
import com.example.springSecurity.sequrity.Mapper.ProductMapper;
import com.example.springSecurity.sequrity.Repositories.ProductRepository;
import com.example.springSecurity.sequrity.loger.FormLogInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
@Service
@Slf4j
@Transactional
public class ProductService implements com.example.springSecurity.sequrity.Service.ProductService {
    ProductRepository productRepository;
    ProductMapper productMapper;
    Product product;

    @Override
    public ProductDTO getAdById(int id) {
        Product product = productRepository.findById(id).orElseThrow(ElemNotFound::new);
        return productMapper.toDTO(product);
    }

    @Override
    public ProductDTO updateAds(int id, ProductDTO productDTO, Authentication authentication) {
        Product product1 = productMapper.toEntity(productDTO);
        return productMapper.toDTO(productRepository.save(product1));
    }

    @Override
    public ProductDTO addAds(ProductDTO productDTO, Authentication authentication) throws IOException {
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
}
