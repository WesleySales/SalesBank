package com.salesbanking.controllers;

import com.salesbanking.entities.Cliente;
import com.salesbanking.entities.ContaBancaria;
import com.salesbanking.services.ClienteService;
import com.salesbanking.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
