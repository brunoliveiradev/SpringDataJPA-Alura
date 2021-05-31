package com.bhmo.spring.data.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_cargos")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;

    @OneToMany(mappedBy = "cargo", cascade = CascadeType.ALL )
    private List<Funcionario> funcionarios = new ArrayList<>();

    public Cargo() {
    }

    public Cargo(String descricao) {
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "id = " + id +
                ", descrição = '" + descricao + '\'' +
                '}';
    }
}
