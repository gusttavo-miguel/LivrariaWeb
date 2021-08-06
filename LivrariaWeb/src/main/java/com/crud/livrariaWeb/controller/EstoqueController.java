package com.crud.livrariaWeb.controller;

import com.crud.livrariaWeb.model.Estoque;
import com.crud.livrariaWeb.service.EstoqueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/estoque")
public class EstoqueController {

    private EstoqueService estoqueService;

    @PostMapping(path = "/cadastro")
    public ResponseEntity<Estoque> cadastro(@RequestBody Estoque estoque) {
        Estoque estoqueSalvo = estoqueService.save(estoque);
        return ResponseEntity.status(HttpStatus.CREATED).body(estoqueSalvo);
    }

    @GetMapping(path = "/buscar/id/{id}")
    public ResponseEntity<Estoque> findByLivro(@PathVariable("id") Integer id) {
        Optional<Estoque> estoque = Optional.ofNullable(estoqueService.findById(id));

        if (estoque.isPresent()) {
            return ResponseEntity.ok(estoque.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(path = "/buscar/todos")
    public List<Estoque> consultar() {
        return estoqueService.findAll();
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        estoqueService.deleteById(id);
    }

    @PutMapping(path = "/Update")
    public Estoque update(@RequestBody Estoque livros) {
        return estoqueService.save(livros);
    }
}
