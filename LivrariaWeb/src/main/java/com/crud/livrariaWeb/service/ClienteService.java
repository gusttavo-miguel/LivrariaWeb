package com.crud.livrariaWeb.service;

import com.crud.livrariaWeb.model.Clientes;
import java.util.List;

public interface ClienteService {

    public Clientes cadastro(Clientes clientes);
    public List<Clientes> findAll ();
    public Clientes findById(Integer id);
    public Clientes findByEmail(String email);
    public Clientes save (Clientes cliente);
    public Clientes update (Clientes cliente);
    public void deleteById (Integer id);
    //    public Clientes findByNome(String nome);

}
