package com.crud.livrariaWeb.model;

import lombok.Data;
import org.hibernate.annotations.Cascade;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "estoque")
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Size(min = 0)
    private Long quantidadeTotal;

    @Column
    @Size(min = 0)
    private Double valorUni;

    @OneToMany(mappedBy = "estoque", orphanRemoval = true)
    @Cascade(value = {org.hibernate.annotations.CascadeType.ALL })
    @Column(name = "lotes", nullable = true)
    private List<Lote> lotes = new ArrayList<>();
}
