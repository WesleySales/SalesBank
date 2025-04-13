package com.sales.salesbank.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "contas")
public class ContaBancaria {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long idConta;

    private String agencia;
    private String numeroDaConta;

    @JsonProperty("Saldo Atual")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "R$ #,##0.00")
    private double saldo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    @JsonIgnoreProperties({"id","cpf", "senha","email"})
    private Cliente titular;
//
//    @OneToMany(mappedBy = "contaOrigem")
//    private List<Transacao> transferenciasEnviadas;
//
//    @OneToMany(mappedBy = "contaDestino")
//    private List<Transacao> transferenciasRecebidas;

    private Double limiteDiario = 1000.0;

    private Double valorUsadoHoje = 0.0;

    private LocalDate dataUltimaTransacao = LocalDate.now();

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


    public Double getLimiteDiario() {
        return limiteDiario;
    }

    public void setLimiteDiario(Double limiteDiario) {
        this.limiteDiario = limiteDiario;
    }

    public Double getValorUsadoHoje() {
        return valorUsadoHoje;
    }

    public void setValorUsadoHoje(Double valorUsadoHoje) {
        this.valorUsadoHoje = valorUsadoHoje;
    }

    public LocalDate getDataUltimaTransacao() {
        return dataUltimaTransacao;
    }

    public void setDataUltimaTransacao(LocalDate dataUltimaTransacao) {
        this.dataUltimaTransacao = dataUltimaTransacao;
    }

    @Override
    public String toString() {
        return "ContaBancaria{" +
                "id: " + idConta +
                ", agencia: " + agencia +
                ", numero da conta: " + numeroDaConta  +
                ", saldo: R$" + saldo +
                ", titular: " + titular.getNome() +
                '}';
    }
}
