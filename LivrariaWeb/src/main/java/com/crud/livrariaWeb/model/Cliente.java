package com.crud.livrariaWeb.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @Column ( length = 14, unique = true)
    private String cpfCnpj;

    @Column ( length = 30, nullable = false)
    private String nome;

    @Column ( length = 8, nullable = false)
    private String cep;

    @Column ( length = 40, nullable = false)
    private String cidade;

    @Column ( length = 40, nullable = true)
    private String dataCadastro;

    @Column ( length = 100, nullable = true)
    private String email;

    @Column ( length = 50, nullable = false)
    private String logradouro;

    @Column ( length = 11, nullable = true)
    private String telefone;

    @Column ( length = 2, nullable = true)
    private String uf;

    @JsonIgnore
    @OneToMany(mappedBy = "idCliente", orphanRemoval = true)
    @Cascade(value = {org.hibernate.annotations.CascadeType.ALL })
    @Column(name = "vendas", nullable = false)
    private List<Venda> vendas = new ArrayList<>();

}