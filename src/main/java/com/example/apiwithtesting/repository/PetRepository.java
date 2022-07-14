package com.example.apiwithtesting.repository;

import com.example.apiwithtesting.entity.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<PetEntity, Integer> {
}
