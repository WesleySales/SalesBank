package com.salesbanking.repository;


import com.salesbanking.entities.ContaBancaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContasRepository extends JpaRepository<ContaBancaria,Long> {
}
