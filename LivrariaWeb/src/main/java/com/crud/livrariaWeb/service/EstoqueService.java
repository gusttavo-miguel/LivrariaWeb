package com.crud.livrariaWeb.service;

import com.crud.livrariaWeb.model.Estoque;
import java.util.List;

public interface EstoqueService {

    public Estoque cadastro(Estoque estoque);
    public List<Estoque> findAll ();
    public Estoque findById(Integer id);
    public Estoque save (Estoque estoque);
    public Estoque update (Estoque estoque);
    public void deleteById (Integer id);

}
