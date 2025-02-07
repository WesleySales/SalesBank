package com.salesbanking.services;

import com.salesbanking.entities.Cliente;
import com.salesbanking.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    private Cliente cliente;

    @Autowired
    private ClienteRepository repository;
    public void cadastrarCliete(Cliente cliente){
        repository.save(cliente);
    }

}
