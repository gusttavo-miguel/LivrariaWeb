package com.crud.livrariaWeb.model;

import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "venda")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column ( length = 30, nullable = false)
    private String dataLancamento;

    @Column ( length = 2, nullable = false)
    private char tipo;

    @Column ( length = 15, nullable = false)
    private double valor;

    private Integer qntd;

    @ManyToOne
    @JoinColumn (name = "idCliente", nullable = false)
    private Clientes cliente;

    @OneToMany(mappedBy = "venda")
    @Column(name = "idLivros", nullable = false)
    private List<Livros> livros = new ArrayList<>();


}
