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
    /**Заголовок уведомления
     * @param title  */
    String title;
    /**Дата создания уведомления
     * @param createdAt  */
    @Column(name = "created_at")
    LocalDateTime createdN;

    /**Текст уведомления
     *  @param text  */
    @Column(name = "text")
    String text;
}
