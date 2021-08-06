package com.crud.livrariaWeb.controller;

import com.crud.livrariaWeb.model.Cliente;
import com.crud.livrariaWeb.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/clientes")
public class ClientesController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping(path = "/cadastro")
    public ResponseEntity<Cliente> clienteCadastro(@RequestBody Cliente cliente) {
        Cliente clienteSalvo = clienteService.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
    }

    @GetMapping(path = "/buscar/id/{id}")
    public ResponseEntity<Cliente> findCliente(@PathVariable("id") Integer id) {
        Optional<Cliente> cliente = Optional.ofNullable(clienteService.findById(id));

        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }
//    @GetMapping(path = "/buscar/nome/{nome}")
//    public Clientes consultarNome(@PathVariable("nome") String nome) {
//        return clienteService.findByNome(nome);
//    }

    @GetMapping(path = "/buscar/email/{email}")
    public Cliente pesquisaEmail(@PathVariable("email") String email) {
        return clienteService.findByEmail(email);
    }

    @GetMapping(path = "/buscar/todos")
    public List<Cliente> consultar() {
        return clienteService.findAll();
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deletaCliente(@PathVariable("id") Integer id) {
        clienteService.deleteById(id);
    }

    @PutMapping(path = "/Update")
    public Cliente updateCliente(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

}
