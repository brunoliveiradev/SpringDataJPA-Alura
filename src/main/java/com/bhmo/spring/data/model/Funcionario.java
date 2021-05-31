package com.bhmo.spring.data.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_funcionarios")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private BigDecimal salario;
    private String cpf;

    @Column(name = "data_contrato")
    private LocalDate dataContrato = LocalDate.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cargo_id", nullable = false)
    private Cargo cargo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "funcionarios_unidade", joinColumns = {
            @JoinColumn(name = "fk_funcionario") },
            inverseJoinColumns = {
            @JoinColumn(name = "fk_unidade")})
    private List<UnidadeTrabalho> unidadeDeTrabalhos = new ArrayList<>();

    public Funcionario() {
    }

    public Funcionario(String nome, String cpf, BigDecimal salario, Cargo cargo) {
        this.nome = nome;
        this.salario = salario;
        this.cpf = cpf;
        this.cargo = cargo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataContrato() {
        return dataContrato;
    }

    public void setDataContrato(LocalDate dataContrato) {
        this.dataContrato = dataContrato;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }


    public List<UnidadeTrabalho> getUnidadeDeTrabalhos() {
        return unidadeDeTrabalhos;
    }

    public void setUnidadeDeTrabalhos(List<UnidadeTrabalho> unidadeDeTrabalhos) {
        this.unidadeDeTrabalhos = unidadeDeTrabalhos;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Funcionário {" +
                "id = " + id +
                ", Nome = '" + nome + '\'' +
                ", salario = " + salario +
                ", CPF = '" + cpf + '\'' +
                ", Contratação = " + dataContrato +
                ", Cargo = " + cargo.getDescricao() +
                '}';
    }
}
