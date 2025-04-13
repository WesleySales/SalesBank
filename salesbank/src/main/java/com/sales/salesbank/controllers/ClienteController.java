package com.sales.salesbank.controllers;

import com.sales.salesbank.dtos.ClienteDTO;
import com.sales.salesbank.entities.Cliente;
import com.sales.salesbank.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    public ResponseEntity<Cliente> postCliente (@RequestBody ClienteDTO data){
        service.cadastrarCliete(data);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes(){
        var lista = service.listarClientes();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id){
        var cliente = service.buscarPorId(id);
        return ResponseEntity.ok().body(cliente);
    }

}
