package com.sales.salesbank.controllers;

import com.sales.salesbank.entities.ExtratoBancario;
import com.sales.salesbank.services.ExtratoBancarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping(value ="contas/1/saldo")
@RequestMapping(value="contas/{id}/extrato")
public class ExtratoBancarioController {

    @Autowired
    ExtratoBancarioService extratoBancarioService;

//    @GetMapping
//    public ResponseEntity<?> getExtrato(@PathVariable Long id){
//        var extrato = extratoBancarioService.gerarExtrato(id);
//        return ResponseEntity.ok().body(extrato);
//    }

}
