package com.salesbanking.services;

import com.salesbanking.entities.ContaBancaria;
import com.salesbanking.repository.ContasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaService {

    @Autowired
    ContasRepository contasRepository;

    public void salvarConta(ContaBancaria conta){
        contasRepository.save(conta);
    }

    public ContaBancaria buscarContaPorId(Long id){
        return contasRepository.findById(id).get();
    }

    public Boolean verificarSaldo(ContaBancaria conta, double valor){
        return conta.getSaldo()>=valor;
    }

    public void depositar(ContaBancaria conta, double valor){
        conta.setSaldo(conta.getSaldo()+valor);
        System.out.println("Operação realizada com sucesso");
    }

    public void sacar(ContaBancaria conta, double valor){
        if(verificarSaldo(conta,valor)){
            conta.setSaldo(conta.getSaldo()-valor);
            System.out.println("Operação efetuada com sucesso.");
        } else {
            System.out.println("Saldo insulficiente para realizar a operação");
        }
    }
}
