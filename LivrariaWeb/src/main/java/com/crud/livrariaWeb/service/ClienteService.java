package com.crud.livrariaWeb.service;

import com.crud.livrariaWeb.model.Cliente;
import java.util.List;

public interface ClienteService {

    public Cliente cadastro(Cliente cliente);
    public List<Cliente> findAll ();
    public Cliente findById(Integer id);
    public Cliente findByEmail(String email);
    public Cliente save (Cliente cliente);
    public Cliente update (Cliente cliente);
    public void deleteById (Integer id);
}
