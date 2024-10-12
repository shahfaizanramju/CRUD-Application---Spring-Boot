package com.example.crudoperation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crudoperation.entity.EEntity;

@Repository
public interface RRepository extends JpaRepository<EEntity, Long> {
    
}
    