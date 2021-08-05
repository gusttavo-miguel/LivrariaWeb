package com.crud.livrariaWeb.service.impl;

import com.crud.livrariaWeb.model.Livros;
import com.crud.livrariaWeb.repository.LivrosRepository;
import com.crud.livrariaWeb.service.LivrosService;
import com.crud.livrariaWeb.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LivrosServiceImpl implements LivrosService {

    @Autowired
    private LivrosRepository livrosRepository;

    @Override
    public Livros cadastro(Livros livros) {
        Livros livroSalvo = save(livros);
        return livroSalvo;
    }

    @Override
    public List<Livros> findAll() {
        return livrosRepository.findAll();
    }

    @Override
    public Livros findById(Integer id) {
        Optional<Livros> livro = livrosRepository.findById(id);
        return livro.orElseThrow(() -> new ObjectNotFoundException(
                "Código não encontrado! Id: " + id));
    }

    @Override
    public Livros save(Livros livro) {
        return livrosRepository.save(livro);
    }

    @Override
    public Livros update(Livros livro) {
        return livrosRepository.save(livro);
    }

    @Override
    public void deleteById(Integer id) {
        livrosRepository.deleteById(id);
    }
}
