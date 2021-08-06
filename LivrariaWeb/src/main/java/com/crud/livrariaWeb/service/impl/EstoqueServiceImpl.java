package com.crud.livrariaWeb.service.impl;

import com.crud.livrariaWeb.model.Estoque;
import com.crud.livrariaWeb.repository.EstoqueRepository;
import com.crud.livrariaWeb.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


public class EstoqueServiceImpl implements EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Override
    public Estoque cadastro(Estoque estoque) {
        return null;
    }

    @Override
    public List<Estoque> findAll() {
        return null;
    }

    @Override
    public Estoque findById(Integer id) {
        return null;
    }

    @Override
    public Estoque save(Estoque estoque) {
        return null;
    }

    @Override
    public Estoque update(Estoque estoque) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
