/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.servicecustomer.service;

import com.example.servicecustomer.model.Cliente;
import com.example.servicecustomer.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente crearCliente(Cliente cliente) {
        return repository.save(cliente);
    }

    public List<Cliente> listarClientes() {
        return repository.findAll();
    }
}

