package com.sales.salesbank.services;

import com.sales.salesbank.entities.ContaBancaria;
import com.sales.salesbank.entities.ExtratoBancario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExtratoBancarioService {

    @Autowired
    TransacaoService transacaoService;

    @Autowired
    ContaBancariaService contaBancariaService;


}
