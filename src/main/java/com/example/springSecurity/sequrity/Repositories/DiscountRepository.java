package com.example.springSecurity.sequrity.Repositories;
import com.example.springSecurity.sequrity.Entity.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Integer> {
}
