package com.sales.salesbank.entities;

public enum TipoTransacao {
    SAQUE("Saque"),
    DEPOSITO("Depósito"),
    TRANSFERENCIA("Transferência");

    private final String descricao;

    TipoTransacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}