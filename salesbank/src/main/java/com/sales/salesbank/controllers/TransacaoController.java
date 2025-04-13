package com.sales.salesbank.controllers;

import com.sales.salesbank.dtos.TransacaoDTO;
import com.sales.salesbank.entities.Transacao;
import com.sales.salesbank.repositories.TransacaoRepository;
import com.sales.salesbank.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="contas/{id}/servicos")
public class TransacaoController {

    @Autowired
    private TransacaoService service;

    @Autowired
    private TransacaoRepository repository;

    @PostMapping(value = "/{tipo}") //Rota para criar uma transação, pode ser deposito, saque ou transferencia
    public ResponseEntity<Transacao> registrarTransacao(@PathVariable Long id, @PathVariable String tipo, @RequestBody TransacaoDTO data){
        var transacao = service.criarTransacao(id,tipo,data);
        return ResponseEntity.ok().body(transacao);
    }

    @GetMapping //Rota para listar todas as transações de determinda conta
    public ResponseEntity<List<Transacao>> buscarPorId(@PathVariable Long id){
        var listaDeTransacoes = service.buscarTransacoes(id);
        return ResponseEntity.ok().body(listaDeTransacoes);
    }


}
