package com.example.springSecurity.sequrity.Repositories;

import com.example.springSecurity.sequrity.Entity.ProductHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ProductHistoryRepository extends JpaRepository<ProductHistory, Integer> {
Collection<ProductHistory> findAllBy(int id);
}
