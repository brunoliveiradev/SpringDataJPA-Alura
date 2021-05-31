package com.bhmo.spring.data.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_unidade_de_trabalho")
public class UnidadeTrabalho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String descricao;
    String endereco;

    @ManyToMany(mappedBy = "unidadeDeTrabalhos", fetch = FetchType.EAGER)
    private List<Funcionario> funcionarios = new ArrayList<>();

    public UnidadeTrabalho() {
    }

    public UnidadeTrabalho(String descricao, String endereco) {
        this.descricao = descricao;
        this.endereco = endereco;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    @Override
    public String toString() {
        return "Unidades {" +
                "id=" + id +
                ", descrição ='" + descricao + '\'' +
                ", endereço ='" + endereco + '\'' +
                '}';
    }

}
