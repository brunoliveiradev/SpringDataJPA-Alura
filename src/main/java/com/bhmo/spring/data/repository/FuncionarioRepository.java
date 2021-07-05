package com.bhmo.spring.data.repository;

import com.bhmo.spring.data.model.Funcionario;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    //Derivated Query - findBy + atributo java
    List<Funcionario> findByNome(String nome);

    List<Funcionario> findByNome(String nome, Pageable pageable);

// Derivated Query equivalente a JPQL abaixo: List<Funcionario> findByNomeAndSalarioGreaterThanAndDataContratacao(String nome, Double salario, LocalDate dataContratacao);

    //JPQL - nome igual as entidades e atributos do java
    @Query("SELECT F FROM Funcionario F WHERE F.nome = :nome " +
            "AND F.salario >= :salario AND F.dataContratacao = :data ")
    List<Funcionario> findNomeDataSalarioMaiorQue(String nome, Double salario, LocalDate data);

    //Native Query - nome da tabela e atributos tem que ser igual ao do banco de dados
    @Query(value = "SELECT * FROM tb_funcionarios AS F WHERE F.data_contrato >= :data", nativeQuery = true)
    List<Funcionario> findDataContratacaoMaiorQue(LocalDate data);
}
