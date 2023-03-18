package com.example.springSecurity.sequrity.Service;

import com.example.springSecurity.sequrity.DTO.DiscountDTO;
import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;

public interface DiscountService {
    /**
     * Возвращает комментарий
     *
     */
    Collection<DiscountDTO> getDiscoun();
    /**
     * Добавляем новое объявление
     *
     * @return возвращает созданное объявление
     */
    DiscountDTO addDiscoun(DiscountDTO discountDTO)
            throws IOException;
    /**
     * Обновляет объявление
     *
     * @param id - идентификатор объявления
     * @return - обнволенный комментарий
     */
    DiscountDTO updateDiscoun(int id, DiscountDTO discountDTO);


}
