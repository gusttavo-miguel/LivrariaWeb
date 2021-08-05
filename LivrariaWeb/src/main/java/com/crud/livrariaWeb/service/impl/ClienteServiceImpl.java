package com.crud.livrariaWeb.service.impl;

import com.crud.livrariaWeb.model.Clientes;
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
    public Clientes cadastro(Clientes clientes) {
        if (clientes.getNome() == null || clientes.getCpf_cnpj() == null) {
            String alerta = "Nome e/ou cpf inválidos!";
            return null;
        }
        LocalDateTime data = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        clientes.setDataCadastro(data.format(formatter));
        Clientes clienteSalvo = save(clientes);
        return clienteSalvo;
    }

    @Override
    public List<Clientes> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Clientes findById(Integer id) {
        Optional<Clientes> cliente = clienteRepository.findById(id);
        return cliente.orElseThrow(() -> new ObjectNotFoundException(
                "Código não encontrado! Id: " + id));
    }

//    @Override
//    public Clientes findByNome(String nome) {
//        return null;
//    }

    @Override
    public Clientes findByEmail(String email) {
        Optional<Clientes> cliente = Optional.ofNullable(clienteRepository.findByEmail(email));
        return cliente.orElseThrow(() -> new ObjectNotFoundException(
                "Email não encontrado! email: " + email));
    }

    @Override
    public Clientes save(Clientes cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Clientes update(Clientes cliente) {
        //Clientes newCliente = findId(cliente.getId());
        //updateData(newCliente, clienteModel);
        return clienteRepository.save(cliente);
    }

    @Override
    public void deleteById(Integer id) {
        clienteRepository.deleteById(id);
    }

}

