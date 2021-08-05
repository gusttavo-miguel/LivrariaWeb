package com.crud.livrariaWeb.repository;


import com.crud.livrariaWeb.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Integer> {

    //Clientes findByNome(String nome);
    Clientes findByEmail(String email);
    void deleteById(Long id);


}
