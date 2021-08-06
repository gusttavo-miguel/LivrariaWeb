package com.crud.livrariaWeb.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity(name = "lotes")
public class Lote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLote;

    @Column(name = "quantidade_Lote")
    @Size(min = 0)
    private Long quantidadeLote;

    @Column(name = "data_recepção")
    private String dataRecepcao;

    @ManyToOne
    @JoinColumn(name = "idEstoque", nullable = false)
    private Estoque estoque;

}
