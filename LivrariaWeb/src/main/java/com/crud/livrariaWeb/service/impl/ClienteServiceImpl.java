package com.crud.livrariaWeb.service.impl;

import com.crud.livrariaWeb.model.Cliente;
import com.crud.livrariaWeb.repository.ClientesRepository;
import com.crud.livrariaWeb.service.ClienteService;
import com.crud.livrariaWeb.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClientesRepository clienteRepository;

    @Override
    public Cliente cadastro(Cliente cliente) {

        LocalDateTime data = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        cliente.setDataCadastro(data.format(formatter));
        return save(cliente);
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findById(Integer id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElseThrow(() -> new ObjectNotFoundException(
                "Código não encontrado! Id: " + id));
    }

//    @Override
//    public Clientes findByNome(String nome) {
//        return null;
//    }

    @Override
    public Cliente findByEmail(String email) {
        Optional<Cliente> cliente = Optional.ofNullable(clienteRepository.findByEmail(email));
        return cliente.orElseThrow(() -> new ObjectNotFoundException(
                "Email não encontrado! email: " + email));
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente update(Cliente cliente) {
        //Clientes newCliente = findId(cliente.getId());
        //updateData(newCliente, clienteModel);
        return clienteRepository.save(cliente);
    }

    @Override
    public void deleteById(Integer id) {
        clienteRepository.deleteById(id);
    }

}

