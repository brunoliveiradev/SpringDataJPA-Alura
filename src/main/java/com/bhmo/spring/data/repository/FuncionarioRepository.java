package com.bhmo.spring.data.repository;

import com.bhmo.spring.data.model.Funcionario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer> {

    //Derivated Query
    List<Funcionario> findByNome(String nome);

// Derivated Query equivalente a JPQL abaixo: List<Funcionario> findByNomeAndSalarioGreaterThanAndDataContratacao(String nome, Double salario, LocalDate dataContratacao);

    //JPQL
    @Query("SELECT F FROM Funcionario F WHERE F.nome = :nome " +
            "AND F.salario >= :salario AND F.dataContratacao = :data ")
    List<Funcionario> findNomeDataSalarioMaiorQue(String nome, Double salario, LocalDate data);

    //Native Query
    @Query(value = "SELECT * FROM tb_funcionarios AS F WHERE F.data_contrato >= :data", nativeQuery = true)
    List<Funcionario> findDataContratacaoMaiorQue(LocalDate data);
}
