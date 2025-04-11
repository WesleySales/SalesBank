package com.salesbanking.services;

import com.salesbanking.entities.ContaBancaria;
import com.salesbanking.entities.Transacao;
import com.salesbanking.repository.ContasRepository;
import com.salesbanking.repository.TransacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransacaoService {
    @Autowired
    ContaService contaService;

    @Autowired
    TransacaoRepository transacaoRepository;

    @Autowired
    ContasRepository contasRepository;

    //funcao que registra a operação
    public void registrarTransacao(Long contaDestino, Long contaOrigem, double valor){
        var destino = contaService.buscarContaPorId(contaDestino); //busca a conta a partir do id
        var origem = contaService.buscarContaPorId(contaOrigem); //busca a conta a partir do id
        Transacao transacao = new Transacao(destino,origem,valor); //cria a transação de qualquer forma

        if(contaService.verificarSaldo(origem,valor)){ //verifica se há saldo e efetua as operações caso verdadeiro
            atualizarSaldo(destino,origem,valor); //atualiza o saldo das contas relacionadas
            salvarTransacao(transacao);
        } else {
            transacao.setStatusTransacao(false); //muda o status da transacao para false, assim ficará evidente no banco de dados que ocorreu um erro
            salvarTransacao(transacao);
        }
    }

    //funcao que salva a movimentação dos valores. Adiciona o valor na contaDestino e retira da contaOrigem
    public void atualizarSaldo(ContaBancaria contaDestino, ContaBancaria contaOrigem, double valor){
        contaService.depositar(contaDestino,valor);
        contaService.sacar(contaOrigem,valor);
        contaService.salvarConta(contaOrigem);
        contaService.salvarConta(contaDestino);
    }

    //funcao para salvar a transação. obs: mesmo que nao seja concretizada ela será salva com status false
    public void salvarTransacao(Transacao transacao){
        if(!transacao.isStatusTransacao()){
            System.out.println("Saldo insuficiente para realizar a operação");
            transacaoRepository.save(transacao); //mesmo que nao seja concretizada, eu quero salvar a tentativa de transação e vou exibir status "falhou"
        } else {
            System.out.format("Seu pix de R$ %.2f foi enviado para %s - horário: %s"
                    ,transacao.getValorTransacao(), transacao.getContaDestino().getTitular().getNome(),transacao.getDataTransacao());
            transacaoRepository.save(transacao);
        }
    }

    //funcao para listar todas as transações (efetuadas ou não) de todas as contas
    public List<Transacao> listarTransacoes(){
        return transacaoRepository.findAll();
    }

    //funcao para listar as transações (enviadas e recebidas) de uma conta específica
    public List<Transacao> listarTransacoesPorConta(Long id_conta){
        List<Transacao> lista = new ArrayList<>();
        for(Transacao t: listarTransacoes()){
            if(t.getContaOrigem().getIdConta()==id_conta || t.getContaDestino().getIdConta()==id_conta){
                lista.add(t);
            }
        }
        return lista;
    }
     //funcao para buscar as ultimas 3 transacoes da conta
    public List<Transacao> exibirExtratoSimplificado(Long id_conta){
        List<Transacao> lista = listarTransacoesPorConta(id_conta);
        List<Transacao> listaExtrato = new ArrayList<>();
        for(int i=0;i<3; i++){
            listaExtrato.add(lista.getLast());
        }
        return listaExtrato;
    }

//    public List<Transacao> exibirExtratoSimplificado(Long id_conta){
//        List<Transacao> lista = listarTransacoesPorConta(id_conta);
//        return lista;
//    }

    //funcao para listar as transações efetuadas
    public List<Transacao> listarTransacoesEfetuadas(){
        List<Transacao> lista = new ArrayList<>();
        for(Transacao t: listarTransacoes()){
            if(t.isStatusTransacao()){
                lista.add(t);
            }
        }
        return lista;
    }

}
