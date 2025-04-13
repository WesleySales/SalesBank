package com.sales.salesbank.entities;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sales.salesbank.dtos.TransacaoDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "Transacoes")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransacao;

    @ManyToOne
    @JoinColumn(name = "conta_origem_id")
    @JsonIgnoreProperties({"id", "Saldo Atual"})
    private ContaBancaria contaOrigem;

    @ManyToOne
    @JoinColumn(name = "conta_destino_id")
    @JsonIgnoreProperties({"id", "Saldo Atual"})
    private ContaBancaria contaDestino;

    @JsonProperty("Valor")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "R$ #,##0.00")
    private Double valorTransacao;

    @JsonProperty("Data")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataTransacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_transacao", nullable = false)
    private TipoTransacao tipoTransacao;

    @JsonIgnore
    private boolean statusTransacao = true;

    public Transacao() {
        this.dataTransacao = LocalDateTime.now();
    }

    public Transacao(ContaBancaria contaOrigem, ContaBancaria contaDestino, Double valorTransacao, LocalDateTime dataTransacao, TipoTransacao tipoTransacao) {
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.valorTransacao = valorTransacao;
        this.dataTransacao = LocalDateTime.now();
        this.tipoTransacao = tipoTransacao;
    }

//    public Transacao(ContaBancaria contaOrigem, TransacaoDTO data) {
//        this.contaOrigem = contaOrigem;
//        this.contaDestino = data.;
//        this.valorTransacao = valorTransacao;
//        this.dataTransacao = LocalDateTime.now();
//        this.tipoTransacao = tipoTransacao;
//    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(TipoTransacao tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public void setStatusTransacao(boolean statusTransacao) {
        this.statusTransacao = statusTransacao;
    }

    public boolean isStatusTransacao() {
        return statusTransacao;
    }

    public Long getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(Long idTransacao) {
        this.idTransacao = idTransacao;
    }

    public ContaBancaria getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(ContaBancaria contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public ContaBancaria getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(ContaBancaria contaDestino) {
        this.contaDestino = contaDestino;
    }

    public Double getValorTransacao() {
        return valorTransacao;
    }

    public void setValorTransacao(double valorTransacao) {
        this.valorTransacao = valorTransacao;
    }

    public LocalDateTime getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(LocalDateTime dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "idTransacao=" + idTransacao +
                ", origem=" + contaOrigem +
                ", destino=" + contaDestino +
                ", valor=" + valorTransacao +
                ", data=" + dataTransacao +
                ", efetuada=" + statusTransacao +
                '}';
    }
}

