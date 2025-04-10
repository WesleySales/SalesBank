package com.salesbanking.services;

import com.salesbanking.entities.ContaBancaria;
import com.salesbanking.entities.Transacao;
import com.salesbanking.repository.ContasRepository;
import com.salesbanking.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {

    @Autowired
    ContasRepository contasRepository;

    @Autowired
    TransacaoRepository transacaoRepository;

    public void salvarConta(ContaBancaria conta){
        contasRepository.save(conta);
    }

    public Boolean verificarSaldo(ContaBancaria conta, double valor){
        return conta.getSaldo()>=valor;
    }

    public void depositar(ContaBancaria conta, double valor){
        conta.setSaldo(conta.getSaldo()+valor);
        salvarConta(conta);
    }

    public void sacar(ContaBancaria conta, double valor){
        if(verificarSaldo(conta,valor)){
            conta.setSaldo(conta.getSaldo()-valor);
        }
    }

    public List<ContaBancaria> listarContas(){
        return contasRepository.findAll();
    }

    public ContaBancaria buscarContaPorId(Long id){
        return contasRepository.findById(id).get();
    }
}
