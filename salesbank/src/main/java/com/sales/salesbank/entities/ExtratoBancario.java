package com.sales.salesbank.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;


public class ExtratoBancario {

    @JsonIgnoreProperties({"idConta","titular"})
    private ContaBancaria contaBancaria;

    @JsonProperty("Movimentações")
    @JsonIgnoreProperties({"idTransacao","statusTransacao","contaOrigem","contaDestino"})
    private List<Transacao> listaTransacoes = new ArrayList<>();

    public ExtratoBancario(ContaBancaria conta) {
        this.contaBancaria = conta;
    }

    public void setListaTransacoes(List<Transacao> listaTransacoes) {
        this.listaTransacoes = listaTransacoes;
    }

    public ContaBancaria getContaBancaria() {
        return contaBancaria;
    }

    public void setContaBancaria(ContaBancaria contaBancaria) {
        this.contaBancaria = contaBancaria;
    }

    public List<Transacao> getListaTransacoes() {
        return listaTransacoes;
    }

    @Override
    public String toString() {
        return "Extrato Bancário: \nTitular: "+contaBancaria.getTitular().getNome()+
                "\nSaldo Atual: "+ contaBancaria.getSaldo() +
                "\nExtrato{ " + listaTransacoes;
    }
}
