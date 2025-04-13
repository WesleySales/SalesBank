package com.sales.salesbank;

import com.sales.salesbank.entities.TipoTransacao;
import com.sales.salesbank.entities.Transacao;
import com.sales.salesbank.repositories.ContaBancariaRepository;
import com.sales.salesbank.repositories.TransacaoRepository;
import com.sales.salesbank.services.ClienteService;
import com.sales.salesbank.services.ContaBancariaService;
import com.sales.salesbank.services.ExtratoBancarioService;
import com.sales.salesbank.services.TransacaoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDateTime;

@SpringBootApplication
@EntityScan(basePackages = {
		"com.sales.salesbank.entities" // Escaneia APENAS classes com @Entity
})

public class SalesbankApplication implements CommandLineRunner {

	@Autowired
	ClienteService clienteService;

	@Autowired
	ContaBancariaRepository contasRepository;

	@Autowired
	ContaBancariaService contaService;

	@Autowired
	TransacaoService transacaoService;

	@Autowired
	TransacaoRepository transacaoRepository;

	@Autowired
	ExtratoBancarioService extratoBancarioService;

	public static void main(String[] args) {
		SpringApplication.run(SalesbankApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("SPRING FUNCIONANDO. BEM VINDO AO SALESBANKING");
	}
}
