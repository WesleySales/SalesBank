package com.salesbanking.repository;

import com.salesbanking.entities.Cliente;
import com.salesbanking.entities.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

//    @Query(value = "SELECT * FROM nome_da_view WHERE coluna = ?1", nativeQuery = true)
//    List<Object[]> buscarDadosDaView(String parametro);
//    public List<Transacao> buscarTransacoesPorConta(Long id);
}
