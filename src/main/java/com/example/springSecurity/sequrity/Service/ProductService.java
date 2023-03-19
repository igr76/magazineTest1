package com.example.springSecurity.sequrity.Service;

import com.example.springSecurity.sequrity.DTO.Categories;
import com.example.springSecurity.sequrity.DTO.NotificationDTO;
import com.example.springSecurity.sequrity.DTO.ProductDTO;
import com.example.springSecurity.sequrity.DTO.ProductDTOHistory;
import com.example.springSecurity.sequrity.Entity.Product;
import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;

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
    Collection<ProductDTO> getAllProduct(Categories categories);
    /**
     * Возвращает объявление
     *
     * @param id - идентификатор объявления
     * @return - комментарий
     */
    ProductDTO getProductById(int id);

    /**
     * Обновляет объявление
     *
     * @param id - идентификатор объявления
     * @return - обнволенный комментарий
     */
    ProductDTO updateProduct(int id, ProductDTO productDTO, Authentication authentication);
    /**
     * Добавляем новое объявление
     *
     * @return возвращает созданное объявление
     */
    ProductDTO addProduct(ProductDTO productDTO,  Authentication authentication)  throws IOException;

    /**
     * Удаляет комментарий
     */
    void deleteProduct(int id, Authentication authentication);
    /**
     * Добавляем новое объявление
     *
     * @return возвращает созданное объявление
     */
    Collection<NotificationDTO> getNotification(int id,NotificationDTO notificationDTO);
    /**
     * Добавляем новое объявление
     *
     * @return возвращает созданное объявление
     */
    void addNotification(int id,NotificationDTO notificationDTO)  throws IOException;
    /**
     * Добавляем новое объявление
     *
     * @return возвращает созданное объявление
     */
    void buyProduct(int id,ProductDTO productDTO,Authentication authentication)  ;

    /**
     * Возвращает объявление
     *
     * @param id - идентификатор объявления
     * @return - комментарий
     */
    Collection<ProductDTOHistory> getProductDTOHistoryById(int id,Authentication authentication);

    /** Возврат продукта    */
    void refundProduct(int id,Authentication authentication) ;






}
