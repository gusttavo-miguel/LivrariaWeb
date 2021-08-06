package com.crud.livrariaWeb.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "vendas")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenda;

    @Column ( length = 30, nullable = false)
    private String dataLancamento;

    @Column ( length = 2, nullable = false)
    private char tipo;

    @Column ( length = 15, nullable = false)
    @Size(min = 0)
    private Double valorTotal;

    @Column
    @Size(min = 0)
    private Long quantidadeUni;

    @ManyToOne
    @JoinColumn(name = "idCliente", nullable = false)
    private Cliente idCliente;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "venda_livro",
            joinColumns = {@JoinColumn(name = "venda_id")},
            inverseJoinColumns = {@JoinColumn(name= "livro_id")})
    private List<Livros> livros = new ArrayList<>();


}
