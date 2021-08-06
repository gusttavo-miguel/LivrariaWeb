package com.crud.livrariaWeb.controller;

import com.crud.livrariaWeb.model.Livros;
import com.crud.livrariaWeb.service.LivrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/livros")
public class LivrosController {

    private LivrosService livrosService;

    @PostMapping(path = "/cadastro")
    public ResponseEntity<Livros> livroCadastro(@RequestBody Livros livros) {
        Livros livroSalvo = livrosService.save(livros);
        return ResponseEntity.status(HttpStatus.CREATED).body(livroSalvo);
    }

    @GetMapping(path = "/buscar/id/{id}")
    public ResponseEntity<Livros> findByLivro(@PathVariable("id") Integer id) {
        Optional<Livros> livro = Optional.ofNullable(livrosService.findById(id));

        if (livro.isPresent()) {
            return ResponseEntity.ok(livro.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(path = "/buscar/todos")
    public List<Livros> consultar() {
        return livrosService.findAll();
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deletaCliente(@PathVariable("id") Integer id) {
        livrosService.deleteById(id);
    }

    @PutMapping(path = "/Update")
    public Livros updateCliente(@RequestBody Livros livros) {
        return livrosService.save(livros);
    }

}
