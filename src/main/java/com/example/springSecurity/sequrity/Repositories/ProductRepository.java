package com.example.springSecurity.sequrity.Repositories;

import com.example.springSecurity.sequrity.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
/**
 * репозиторий для объявления
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(nativeQuery = true, value = "SELECT MAX(ID) FROM product")
    int findMaxID();
}
