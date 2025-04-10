package com.salesbanking.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "contas")
public class ContaBancaria {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idConta;

    private String agencia;
    private String numeroDaConta;
    private double saldo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private Cliente titular;

    @OneToMany(mappedBy = "contaOrigem")
    private List<Transacao> transacoesOrigem;

    @OneToMany(mappedBy = "contaDestino")
    private List<Transacao> transacoesDestino;

    public ContaBancaria() {
    }

    public ContaBancaria( String agencia, String numeroDaConta, double saldo, Cliente titular) {
        this.agencia = agencia;
        this.numeroDaConta = numeroDaConta;
        this.saldo = saldo;
        this.titular = titular;
    }

    public Long getIdConta() {
        return idConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getNumeroDaConta() {
        return numeroDaConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getTitular() {
        return titular;
    }

    @Override
    public String toString() {
        return "ContaBancaria{" +
                "idConta=" + idConta +
                ", agencia='" + agencia + '\'' +
                ", numeroDaConta='" + numeroDaConta + '\'' +
                ", saldo=" + saldo +
                ", titular=" + titular.getNome() +
                '}';
    }
}
