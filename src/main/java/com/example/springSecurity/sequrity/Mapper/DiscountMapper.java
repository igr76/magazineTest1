package com.example.springSecurity.sequrity.Mapper;

import com.example.springSecurity.sequrity.DTO.DiscountDTO;
import com.example.springSecurity.sequrity.Entity.Discount;
import org.mapstruct.Mapper;
/**
 * маппер дляготовый DTO
 */
@Mapper(componentModel = "spring")
public interface DiscountMapper {
    Discount toEntity(DiscountDTO discountDTO);

    DiscountDTO toDTO(Discount discount);
}
