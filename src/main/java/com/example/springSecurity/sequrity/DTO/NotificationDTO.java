package com.example.springSecurity.sequrity.DTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NotificationDTO {
    /**Заголовок уведомления */
    String title;
    /**Дата создания уведомления      */
    @Column(name = "created_at")
    LocalDateTime createdN;

    /**   Текст уведомления     */
    @Column(name = "text")
    String text;
}
