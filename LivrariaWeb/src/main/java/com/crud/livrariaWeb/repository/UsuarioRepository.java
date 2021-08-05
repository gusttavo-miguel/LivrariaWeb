package com.crud.livrariaWeb.repository;

import com.crud.livrariaWeb.model.Funcionarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Funcionarios, Integer> {

    Funcionarios findByNome(String nome);
    Funcionarios findByEmail(String email);
    Funcionarios findByLoginAndSenha (String login, String senha);

}