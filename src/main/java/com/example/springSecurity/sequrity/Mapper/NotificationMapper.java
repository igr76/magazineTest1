package com.example.springSecurity.sequrity.Mapper;

import com.example.springSecurity.sequrity.DTO.NotificationDTO;
import com.example.springSecurity.sequrity.Entity.Notification;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.Optional;

/**
 * маппер для {@link Notification} готовый DTO {@link NotificationDTO}
 */
@Mapper(componentModel = "spring")
public interface NotificationMapper {
    Notification toEntity(NotificationDTO notificationDTO);

    NotificationDTO toDTO(Notification notification);
    Collection<NotificationDTO> toDTONotificationList(Optional<Notification> notifications);

}
