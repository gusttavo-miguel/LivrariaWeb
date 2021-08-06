package com.crud.livrariaWeb.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity(name = "funcionarios")
public class Funcionarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFuncionario;

    @Column (length = 30, nullable = false)
    private String dataCadastro;

    @Column ( length = 30, nullable = false)
    private String nome;

    @Column ( length = 15, nullable = false)
    private String login;

    @Column ( length = 10, nullable = false)
    private String senha;

    @Column ( length = 11, nullable = true)
    private String telefone;

    @Column ( length = 100, nullable = true)
    private String email;

    @Column ( length = 1, nullable = false)
    private String perfil;

    @Column ( length = 1, nullable = false)
    private String status;
}