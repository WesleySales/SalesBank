package com.salesbanking.controllers;

import com.salesbanking.entities.Cliente;
import com.salesbanking.entities.Transacao;
import com.salesbanking.services.ClienteService;
import com.salesbanking.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="contas/{id}/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService service;

    @GetMapping
    public ResponseEntity<List<Transacao>> buscarPorId(@PathVariable Long id){
        var listaDeTransacoes = service.listarTransacoesPorConta(id);
        return ResponseEntity.ok().body(listaDeTransacoes);
    }


}
