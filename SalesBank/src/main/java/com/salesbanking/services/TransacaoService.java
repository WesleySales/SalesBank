package com.salesbanking.services;

import com.salesbanking.entities.ContaBancaria;
import com.salesbanking.entities.Transacao;
import com.salesbanking.repository.ContasRepository;
import com.salesbanking.repository.TransacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {
    @Autowired
    ContaService contaService;

    @Autowired
    TransacaoRepository transacaoRepository;

    @Autowired
    ContasRepository contasRepository;

    public Transacao registrarTransacao(Long contaDestino, Long contaOrigem, double valor){
        var destino = contaService.buscarContaPorId(contaDestino);
        var origem = contaService.buscarContaPorId(contaOrigem);
        if(contaService.verificarSaldo(origem,valor)){
            Transacao transacao = new Transacao(destino,origem,valor);
            atualizarSaldo(destino,origem,valor);
            return transacao;
        }
        return null;
    }

    public void atualizarSaldo(ContaBancaria contaDestino, ContaBancaria contaOrigem, double valor){
        contaService.depositar(contaDestino,valor);
        contaService.sacar(contaOrigem,valor);
        contaService.salvarConta(contaOrigem);
        contaService.salvarConta(contaDestino);
    }

    public void salvarTransacao(Transacao transacao){
        if(transacao == null){
            System.out.println("Saldo insuficiente para realizar a operação");
        } else {
            System.out.println("Operação realizada com sucesso");
            transacaoRepository.save(transacao);
        }

    }



}
