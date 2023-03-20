package com.example.springSecurity.sequrity.Service.Impl;

import com.example.springSecurity.sequrity.DTO.DiscountDTO;
import com.example.springSecurity.sequrity.Entity.Discount;
import com.example.springSecurity.sequrity.Mapper.DiscountMapper;
import com.example.springSecurity.sequrity.Repositories.DiscountRepository;
import com.example.springSecurity.sequrity.Service.DiscountService;
import com.example.springSecurity.sequrity.exeption.ElemNotFound;

import java.io.IOException;
import java.util.Collection;

public class DiscountServiceImpl implements DiscountService {
    DiscountMapper discountMapper;
    DiscountRepository discountRepository;

    public DiscountServiceImpl(DiscountMapper discountMapper, DiscountRepository discountRepository) {
        this.discountMapper = discountMapper;
        this.discountRepository = discountRepository;
    }
    /**     Получить список скидок     */
    @Override
    public Collection<DiscountDTO> getDiscoun() {
        return discountMapper.toDTOList(discountRepository.findAll());
    }
    /** Добавить скидку     */
    @Override
    public DiscountDTO addDiscoun( DiscountDTO discountDTO) throws IOException {
        Discount discount = discountRepository.save(discountMapper.toEntity(discountDTO));
        return discountMapper.toDTO(discount);
    }
    /**     Изменить скидку     */
    @Override
    public DiscountDTO updateDiscoun(int id, DiscountDTO discountDTO) {
        Discount discount = discountRepository.findById(id).orElseThrow(ElemNotFound::new);
        discountRepository.save(discount);
        return discountMapper.toDTO(discount);
    }
}
