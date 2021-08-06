package com.crud.livrariaWeb.model;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "livros")
public class Livros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLivro;

    @Column(length = 20, nullable = false)
    private String nome;

    @Column(length = 9, nullable = false)
    private String genero;

    @Column(length = 50, nullable = false)
    private String descricao;

    @OneToOne(cascade = CascadeType.ALL)
    @Size(min = 0)
    private Estoque estoque;

    @ManyToMany(mappedBy= "livros", cascade = CascadeType.ALL)
    private List<Venda> vendas = new ArrayList<>();

}
