package com.sales.salesbank.entities;

//import com.salesbank.dto.ClienteDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sales.salesbank.dtos.ClienteDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_cliente")
    private String nome;

    @Column(name = "cpf")
    @JsonIgnore
    private String cpf;

    @Column(name = "email_cliente")
    @JsonIgnore
    private String email;

    @JsonIgnore
    private String senha;

    @OneToOne(mappedBy = "titular", cascade = CascadeType.ALL)
    private ContaBancaria contaBancaria;

    public Cliente(){

    }
    public Cliente( String nome, String CPF, String email, String senha) {
        this.nome = nome;
        this.cpf = CPF;
        this.email = email;
        this.senha = senha;
    }

    public Cliente (ClienteDTO data){
        this.id = data.id();
        this.nome = data.nome();
        this.cpf = data.CPF();
        this.email = data.email();
        this.senha = data.senha();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String CPF) {
        this.cpf = CPF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", CPF='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}