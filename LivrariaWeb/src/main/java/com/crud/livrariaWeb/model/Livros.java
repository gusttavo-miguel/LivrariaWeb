package com.crud.livrariaWeb.model;

import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "livros")
public class Livros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String nome;

    @Column(length = 9, nullable = false)
    private String genero;

    @Column(length = 50, nullable = false)
    private String descricao;

    @OneToMany(mappedBy = "livros")
    @Column
    private List<Estoque> lotes = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "idVenda")
    private Venda venda;


}
