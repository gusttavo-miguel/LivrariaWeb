package com.crud.livrariaWeb.service;
import com.crud.livrariaWeb.model.Livros;
import java.util.List;

public interface LivrosService {

    public Livros cadastro(Livros livros);
    public List<Livros> findAll ();
    public Livros findById(Integer id);
    public Livros save (Livros livros);
    public Livros update (Livros livro);
    public void deleteById (Integer id);
}
