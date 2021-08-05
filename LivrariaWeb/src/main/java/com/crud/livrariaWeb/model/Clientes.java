package com.crud.livrariaWeb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "clientes")
public class Clientes {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column ( length = 30, nullable = false)
    private String nome;

    @Column ( length = 8, nullable = false)
    private String cep;

    @Column ( length = 14, nullable = false, unique = true)
    private String cpf_cnpj;

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

    @Column ( length = 2, nullable = false)
    private String uf;

    @JsonIgnore
    @OneToMany (mappedBy = "cliente") // esse mappedBy faz referência ao nome do objeto do tipo Clientes na classe VendasLivros.
    //ele vai saber onde buscar pelo campo "cliente" de acordo com o tipo do campo declarado aqui, que neste caso, é uma lista
    //do tipo VendasLivros.
    @Column
    private List<Venda> listaLivros = new ArrayList <>();
}