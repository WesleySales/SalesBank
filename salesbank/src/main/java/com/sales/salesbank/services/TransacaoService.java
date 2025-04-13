package com.sales.salesbank.services;

import com.sales.salesbank.dtos.TransacaoDTO;
import com.sales.salesbank.entities.ContaBancaria;
import com.sales.salesbank.entities.TipoTransacao;
import com.sales.salesbank.entities.Transacao;
import com.sales.salesbank.repositories.ContaBancariaRepository;
import com.sales.salesbank.repositories.TransacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.sales.salesbank.entities.TipoTransacao.*;

@Service
public class TransacaoService {

    @Autowired
    ContaBancariaService contaService;

    @Autowired
    TransacaoRepository transacaoRepository;

    @Autowired
    ContaBancariaRepository contasRepository;

    @Transactional
    public Transacao executarTransacao(Transacao transacao) {
        // 1. Validações iniciais
        if (transacao.getTipoTransacao() == null || transacao.getValorTransacao() == null) {
            throw new IllegalArgumentException("Tipo e valor da transação são obrigatórios");
        }

        switch (transacao.getTipoTransacao()) {
            case SAQUE:
                contaService.sacar(transacao.getContaOrigem(), transacao.getValorTransacao());
                System.out.println("SAQUE CONCLUIDO COM SUCESSO. SALDO ATUALIZADO DA CONTA: "+transacao.getContaOrigem().getSaldo());
                break;

            case DEPOSITO:
                contaService.depositar(transacao.getContaOrigem(), transacao.getValorTransacao());
                System.out.println("DEPOSITO CONCLUIDO COM SUCESSO. SALDO ATUALIZADO DA CONTA: "+transacao.getContaOrigem().getSaldo());
                break;

            case TRANSFERENCIA:
                contaService.sacar(transacao.getContaOrigem(), transacao.getValorTransacao());
                contaService.depositar(transacao.getContaDestino(), transacao.getValorTransacao());
                System.out.println("TRANSFERENCIA REALIZADA COM SUCESSO.");
                break;

            default:
                throw new IllegalArgumentException("Tipo de transação inválido: " + transacao.getTipoTransacao());
        }

        transacao.setDataTransacao(LocalDateTime.now());
        return transacaoRepository.save(transacao);
    }

    public Transacao criarTransacao(Long idContaOrigem, String tipo,TransacaoDTO data){
        var transacao = new Transacao();
        System.out.println("estou tentando rodar a funcao CRIARTRANSACAO()");
        transacao.setContaOrigem(contaService.buscarContaPorId(idContaOrigem));
        System.out.println("conta origem: "+transacao.getContaOrigem().getTitular().getNome());

        if(data.idContaDestino()!=null){
            transacao.setContaDestino(contaService.buscarContaPorId(data.idContaDestino()));
            System.out.println("conta destino: "+transacao.getContaDestino().getTitular().getNome());
        }

		transacao.setValorTransacao(data.valor());
		transacao.setTipoTransacao(TipoTransacao.valueOf(tipo.toUpperCase())); //Adicionei toUpper para aceitar a url minuscula tambem
		transacao.setDataTransacao(LocalDateTime.now());

        return executarTransacao(transacao);
    }

    public List<Transacao> buscarTransacoes(Long idConta){
        List<Transacao> lista = new ArrayList<>();
        for(Transacao t: transacaoRepository.findAll()){//buscar apenas transacoes recebidas
           if (t.getContaDestino() != null && idConta.equals(t.getContaDestino().getIdConta()) && t.isStatusTransacao()) {
//               System.out.format("\nO VALOR R$ %.2f RECEBIDO VIA %s", t.getValorTransacao(),t.getTipoTransacao());
////               System.out.format("\nO VALOR R$ %.2f FOI ENVIADO PARA %s ",t.getValorTransacao(),t.getContaDestino().getTitular().getNome());
               lista.add(t);
           } else if (idConta.equals(t.getContaOrigem().getIdConta()) && t.isStatusTransacao()) {
//               if(t.getContaDestino() != null){
//                   System.out.format("\nO VALOR R$ %.2f FOI ENVIADO PARA %s ",t.getValorTransacao(),t.getContaDestino().getTitular().getNome());
//               } else {
////                   System.out.format("\nSAQUE DE R$ %.2f EFETUADO COM SUCESSO ",t.getValorTransacao());
//               }
               lista.add(t);
           }
        }
        return lista;
    }

}