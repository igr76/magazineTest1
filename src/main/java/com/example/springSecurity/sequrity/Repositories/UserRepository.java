package com.example.springSecurity.sequrity.Repositories;

import com.example.springSecurity.sequrity.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
}
