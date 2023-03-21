package com.example.springSecurity.sequrity.Service.Impl;

import com.example.springSecurity.sequrity.DTO.DiscountDTO;
import com.example.springSecurity.sequrity.Entity.Discount;
import com.example.springSecurity.sequrity.Mapper.DiscountMapper;
import com.example.springSecurity.sequrity.Repositories.DiscountRepository;
import com.example.springSecurity.sequrity.Service.DiscountService;
import com.example.springSecurity.sequrity.exeption.ElemNotFound;
import com.example.springSecurity.sequrity.loger.FormLogInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Timer;
import java.util.TimerTask;

/** * Сервис скидок */
@Service
@Slf4j
@Transactional
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
        log.info(FormLogInfo.getInfo());
        return discountMapper.toDTOList(discountRepository.findAll());
    }
    /** Добавить скидку     */
    @Override
    public DiscountDTO addDiscoun( DiscountDTO discountDTO) throws IOException {
        log.info(FormLogInfo.getInfo());
        Discount discount = discountRepository.save(discountMapper.toEntity(discountDTO));
        return discountMapper.toDTO(discount);
    }
    /**     Изменить скидку     */
    @Override
    public DiscountDTO updateDiscoun(int id, DiscountDTO discountDTO) {
        log.info(FormLogInfo.getInfo());
        Discount discount = discountRepository.findById(id).orElseThrow(ElemNotFound::new);
        discountRepository.save(discount);
        return discountMapper.toDTO(discount);
    }
    /** Ежедневная проверка срока скидок */
    public void givenUsingTimer_whenSchedulingDailyTask_thenCorrect() {
        TimerTask repeatedTask = new TimerTask() {
            public void run() {
                Collection<Discount> discounts = discountRepository.findAll();
                discounts.stream()
                        .filter(e -> e.getCreatedDs().equals(LocalDateTime.now()))
                        .forEach(e -> e.setVolume(null));;
            }
        };
        Timer timer = new Timer("Timer");

        long delay = 1000L;
        long period = 1000L * 60L * 60L * 24L;
        timer.scheduleAtFixedRate(repeatedTask, delay, period);
    }
}
