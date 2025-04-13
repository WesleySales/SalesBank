package com.sales.salesbank.repositories;

import com.sales.salesbank.entities.ContaBancaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaBancariaRepository extends JpaRepository<ContaBancaria,Long> {
}
