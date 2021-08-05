package com.crud.livrariaWeb.repository;

import com.crud.livrariaWeb.model.Livros;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivrosRepository extends JpaRepository<Livros, Integer> {

    void deleteById(Long id);

}
