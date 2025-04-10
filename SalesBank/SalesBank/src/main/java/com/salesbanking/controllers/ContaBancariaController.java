package com.salesbanking.controllers;

import com.salesbanking.entities.Cliente;
import com.salesbanking.entities.ContaBancaria;
import com.salesbanking.services.ClienteService;
import com.salesbanking.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/contas")
public class ContaBancariaController {

    @Autowired
    private ContaService service;

    @GetMapping
    public ResponseEntity<List<ContaBancaria>> listarClientes(){
        var lista = service.listarContas();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<ContaBancaria> buscarPorId(@PathVariable Long id){
        var conta = service.buscarContaPorId(id);
        return ResponseEntity.ok().body(conta);
    }

    @GetMapping(value="/{id}/saldo")
    public ResponseEntity exibirSaldo(@PathVariable Long id){
        var conta = service.buscarContaPorId(id);
        return ResponseEntity.ok().body(
                "Saldo R$: "+conta.getSaldo());
    }

    @PostMapping(value="/{id}/depositar")
    public ResponseEntity<ContaBancaria> depositar(@PathVariable Long id, @RequestBody Double valor){
        var conta = service.buscarContaPorId(id);

//        if (conta == null) {
//            throw new NullPointerException("Conta não encontrada");
//        }
//
//        if (valor <= 0) {
//            throw new IllegalArgumentException("Valor inválido: " + valor);
//        }

        service.depositar(conta,valor);
        return ResponseEntity.ok().body(conta);

    }

    @PostMapping(value="/{id}/sacar")
    public ResponseEntity<ContaBancaria> sacar(@PathVariable Long id, @RequestBody Double valor){
        var conta = service.buscarContaPorId(id);
        service.sacar(conta,valor);
        return ResponseEntity.ok().body(conta);
    }

}
