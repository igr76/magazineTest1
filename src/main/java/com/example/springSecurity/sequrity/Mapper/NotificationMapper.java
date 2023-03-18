package com.example.springSecurity.sequrity.Mapper;

import com.example.springSecurity.sequrity.DTO.NotificationDTO;
import com.example.springSecurity.sequrity.Entity.Notification;
import org.mapstruct.Mapper;

@Mapper
public interface NotificationMapper {
    Notification toEntity(NotificationDTO notificationDTO);

    NotificationDTO toDTO(Notification notification);

}
