package com.example.springSecurity.sequrity.Entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Table;
import java.time.LocalDateTime;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "notification")
public class Notification {
    /**Заголовок уведомления      */
    String title;
    /**Дата создания уведомления      */
    @Column(name = "created_at")
    LocalDateTime createdN;

    /**Текст уведомления       */
    @Column(name = "text")
    String text;
}
