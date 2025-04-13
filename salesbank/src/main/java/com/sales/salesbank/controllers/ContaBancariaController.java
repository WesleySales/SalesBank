package com.sales.salesbank.controllers;

import com.sales.salesbank.entities.ContaBancaria;
import com.sales.salesbank.services.ContaBancariaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/contas")
public class ContaBancariaController {

    @Autowired
    private ContaBancariaService service;

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

}