package com.salesbanking.repository;

import com.salesbanking.entities.Cliente;
import com.salesbanking.entities.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
