package com.vitormwxm.modelo_dominio_orm.entities;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_atividade")
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    private Double preco;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria; // coluna que vai fazer a referência

    @ManyToMany
    @JoinTable(name = "tb_atividade_participante",
               joinColumns = @JoinColumn(name = "atividade_id"),
               inverseJoinColumns = @JoinColumn(name = "participante_id"))
    private List<Participante> participantes;

    @OneToMany(mappedBy = "atividade", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bloco> blocos = new ArrayList<>();
}
