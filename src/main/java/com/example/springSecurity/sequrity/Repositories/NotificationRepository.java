package com.example.springSecurity.sequrity.Repositories;

import com.example.springSecurity.sequrity.Entity.Notification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * репозиторий для уведомлений
 */
@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}
