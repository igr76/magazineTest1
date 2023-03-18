package com.example.springSecurity.sequrity.Repositories;

import com.example.springSecurity.sequrity.Entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
}
