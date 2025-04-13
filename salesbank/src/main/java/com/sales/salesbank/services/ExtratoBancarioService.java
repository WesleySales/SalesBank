package com.sales.salesbank.services;

import com.sales.salesbank.entities.ContaBancaria;
import com.sales.salesbank.entities.ExtratoBancario;
import com.sales.salesbank.entities.Transacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExtratoBancarioService {

    @Autowired
    TransacaoService transacaoService;

    @Autowired
    ContaBancariaService contaBancariaService;

    //Mostra as ultimas 8 movimentações da conta
    public List<Transacao> exibirExtratoSimplificado(Long idConta){
        List<Transacao> transacoes = transacaoService.buscarTransacoes(idConta);
        List<Transacao> extrato = new ArrayList<>();
        for(int i=1;i<=8;i++){
            extrato.add(transacoes.get(transacoes.size()-i));
        }
        return extrato;
    }
}
