package com.sales.salesbank.services;

import com.sales.salesbank.entities.ContaBancaria;
import com.sales.salesbank.repositories.ContaBancariaRepository;
import com.sales.salesbank.repositories.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Service
public class ContaBancariaService {

    @Autowired
    ContaBancariaRepository contasRepository;

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
        resetarLimiteDiario(conta);
        if(!verificarSaldo(conta,valor)){
            throw new RuntimeException("SALDO INSUFICIENTE PARA REALIZAR A OPERAÇÃO!");
        } else if (!verificarLimiteDiario(conta,valor)){
            throw new RuntimeException("LIMITE DIÁRIO EXCEDIDO!");
        } else {
            conta.setSaldo(conta.getSaldo() - valor);
            conta.setValorUsadoHoje(conta.getValorUsadoHoje() + valor);
//            conta.setLimiteDiario(conta.getLimiteDiario() - conta.getValorUsadoHoje());
            salvarConta(conta);
            System.out.println("Operação realizada, o limite diario foi atualizado para R$: "+conta.getLimiteDiario());
        }
    }

    public List<ContaBancaria> listarContas(){
        return contasRepository.findAll();
    }

    public ContaBancaria buscarContaPorId(Long id){
        return contasRepository.findById(id).get();
    }

    private boolean verificarLimiteDiario(ContaBancaria conta, Double valor) {
        return (conta.getValorUsadoHoje() + valor) <= conta.getLimiteDiario();
    }

    private void resetarLimiteDiario(ContaBancaria conta) {
        LocalDate hoje = LocalDate.now(ZoneId.of("America/Sao_Paulo"));
        if (!hoje.equals(conta.getDataUltimaTransacao())) {
            conta.setValorUsadoHoje(0.0);
            conta.setDataUltimaTransacao(hoje);
        }
    }


}
