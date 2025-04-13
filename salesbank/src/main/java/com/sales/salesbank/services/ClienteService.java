package com.sales.salesbank.services;

import com.sales.salesbank.dtos.ClienteDTO;
import com.sales.salesbank.entities.Cliente;
import com.sales.salesbank.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private Cliente cliente;

    @Autowired
    private ClienteRepository repository;

    public void cadastrarCliete(ClienteDTO data){
        var cliente = new Cliente(data);
        repository.save(cliente);
    }

    public List<Cliente> listarClientes(){
        return repository.findAll();
    }

    public Cliente buscarPorId(Long id){
        return repository.findById(id).get();
    }

    public void deletarCliente(Long id){
        var cliente = buscarPorId(id);
        repository.delete(cliente);
    }
}