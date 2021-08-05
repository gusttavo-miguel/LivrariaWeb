package com.crud.livrariaWeb.model;

import lombok.Data;
import javax.persistence.*;

@Entity(name = "estoque")
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer quantidade;

    @Column
    private String dataRecepcao;

    @Column
    private String dataValidade;

    @ManyToOne
    @JoinColumn(name = "idLivros", nullable = false)
    private Livros livros;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Venda venda) {
        this.quantidade = venda.getQntd() - quantidade ;
    }

    public String getDataRecepcao() {
        return dataRecepcao;
    }

    public void setDataRecepcao(String dataRecepcao) {
        this.dataRecepcao = dataRecepcao;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public Livros getLivros() {
        return livros;
    }

    public void setLivros(Livros livros) {
        this.livros = livros;
    }
}
