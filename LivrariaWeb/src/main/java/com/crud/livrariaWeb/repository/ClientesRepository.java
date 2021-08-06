package com.crud.livrariaWeb.repository;


import com.crud.livrariaWeb.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<Cliente, Integer> {

    Cliente findByEmail(String email);
    void deleteById(Integer id);
}
