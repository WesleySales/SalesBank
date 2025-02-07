package com.salesbanking;

import com.salesbanking.entities.Cliente;
import com.salesbanking.entities.Transacao;
import com.salesbanking.repository.ClienteRepository;
import com.salesbanking.repository.ContasRepository;
import com.salesbanking.repository.TransacaoRepository;
import com.salesbanking.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	ContasRepository contasRepository;

	@Autowired
	TransacaoRepository transacaoRepository;

	@Autowired
	TransacaoService transacaoService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Transacao transacao = transacaoService.registrarTransacao(2l,3l,1000);
		Transacao transacao2 = transacaoService.registrarTransacao(4l,1l,1000);
		transacaoService.salvarTransacao(transacao);
		transacaoService.salvarTransacao(transacao2);
	}
}
