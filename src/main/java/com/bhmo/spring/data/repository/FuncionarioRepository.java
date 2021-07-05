package com.bhmo.spring.data.repository;

import com.bhmo.spring.data.model.Funcionario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer> {

    List<Funcionario> findByNome(String nome);

//    List<Funcionario> findByNomeAndSalarioGreaterThanAndDataContratacao(String nome, Double salario, LocalDate dataContratacao);
    // Equivalente ao método abaixo

    @Query("SELECT F FROM Funcionario F WHERE F.nome = :nome " +
            "AND F.salario >= :salario AND F.dataContratacao = :data ")
    List<Funcionario> findNomeDataSalarioMaiorQue(String nome, Double salario, LocalDate data);
}
