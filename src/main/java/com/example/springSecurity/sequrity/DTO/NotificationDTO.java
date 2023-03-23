package com.example.springSecurity.sequrity.DTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NotificationDTO {
    /**
     * id уведомления
     */
    Integer id;

    /**Заголовок уведомления */
    String title;
    /**Дата создания уведомления      */
    @Column(name = "created_at")
    LocalDateTime createdN;

    /**   Текст уведомления     */
    @Column(name = "text")
    String text;

}
