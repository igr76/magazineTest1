package com.example.springSecurity.sequrity.Service;

import com.example.springSecurity.sequrity.DTO.ProductDTO;
import com.example.springSecurity.sequrity.Entity.Product;
import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Сервис объявлений
 */
public interface ProductService {

    /**
     * Возвращает объявление
     *
     * @param id - идентификатор объявления
     * @return - комментарий
     */
    ProductDTO getAdById(int id);

    /**
     * Обновляет объявление
     *
     * @param id - идентификатор объявления
     * @return - обнволенный комментарий
     */
    ProductDTO updateAds(int id, ProductDTO productDTO, Authentication authentication);
    /**
     * Добавляем новое объявление
     *
     * @return возвращает созданное объявление
     */
    ProductDTO addAds(ProductDTO productDTO,  Authentication authentication)  throws IOException;

}
