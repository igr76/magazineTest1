package com.example.springSecurity.sequrity.Repositories;

import com.example.springSecurity.sequrity.Entity.ProductHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
/**
 * репозиторий для истории
 */
@Repository
public interface ProductHistoryRepository extends JpaRepository<ProductHistory, Integer> {
Collection<ProductHistory> findAllBy(int id);
}
