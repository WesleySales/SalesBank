package com.sales.salesbank.repositories;

import com.sales.salesbank.dtos.TransacaoDTO;
import com.sales.salesbank.entities.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao,Long> {

//    @Query("SELECT new com.sales.salesbank.dtos.TransacaoDTO(" +
//            "t.id, clRemetente.nome, clDestinatario.nome, t.valorTransacao, t.dataTransacao, t.tipoTransacao) " +
//            "FROM Transacao t " +
//            "JOIN t.contaOrigem co " +
//            "JOIN co.titular clRemetente " +
//            "LEFT JOIN t.contaDestino cd " +
//            "LEFT JOIN cd.titular clDestinatario " +
//            "WHERE co.id = :contaId OR cd.id = :contaId")
//    List<TransacaoDTO> findTransacoesCompletasPorConta(@Param("contaId") Long contaId);

}
