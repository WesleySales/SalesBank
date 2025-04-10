package com.salesbanking;

import com.salesbanking.entities.Cliente;
import com.salesbanking.entities.Transacao;
import com.salesbanking.repository.ClienteRepository;
import com.salesbanking.repository.ContasRepository;
import com.salesbanking.repository.TransacaoRepository;
import com.salesbanking.services.ClienteService;
import com.salesbanking.services.ContaService;
import com.salesbanking.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	ClienteService clienteService;

	@Autowired
	ContasRepository contasRepository;

	@Autowired
	ContaService contaService;

	@Autowired
	TransacaoRepository transacaoRepository;

	@Autowired
	TransacaoService transacaoService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		Transacao transacao = transacaoService.registrarTransacao(2l,3l,1000);
//		Transacao transacao2 = transacaoService.registrarTransacao(4l,1l,1000);
//		transacaoService.salvarTransacao(transacao);
//		transacaoService.salvarTransacao(transacao2);
//
//		transacaoService.registrarTransacao(1l,3l,2000);
//		transacaoService.registrarTransacao(2l,1l,10000);
//		transacaoService.registrarTransacao(3l,1l,4000);


//		transacaoService.registrarTransacao(3l,2l,2000);

//		var conta = contasRepository.findById(2l).get();

		System.out.println(transacaoRepository.findAll());
		System.out.println("Aqui vou exibir todas as transações de determinada conta: ");
		System.out.println(transacaoService.listarTransacoesPorConta(1l));
		System.out.println("\nAqui vou exibir as ultimas 3 transações de determinada conta: ");
		System.out.println(transacaoService.exibirExtratoSimplificado(1l));
	}
}
