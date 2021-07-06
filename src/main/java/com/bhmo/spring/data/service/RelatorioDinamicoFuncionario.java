package com.bhmo.spring.data.service;

import com.bhmo.spring.data.model.Funcionario;
import com.bhmo.spring.data.repository.FuncionarioRepository;
import com.bhmo.spring.data.specification.SpecificationFuncionario;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Service
public class RelatorioDinamicoFuncionario {

    private final FuncionarioRepository funcionarioRepository;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public RelatorioDinamicoFuncionario(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void iniciar(Scanner scanner) {
        System.out.println("Qual nome deseja pesquisar:");
        String nome = scanner.nextLine().toUpperCase();
        nome += scanner.nextLine().toUpperCase();

        if(nome.equalsIgnoreCase("NULL")){
            nome = null;
        }

        System.out.println("Qual CPF deseja pesquisar:");
        String cpf = scanner.next();
        if(cpf.equalsIgnoreCase("NULL")){
            cpf = null;
        }

        System.out.println("Qual salário deseja pesquisar:");
        Double salario = scanner.nextDouble();
        if(salario == 0 || salario.isNaN() ){
            salario = null;
        }

        System.out.println("Qual data de contratação deseja pesquisar:");
        String data = scanner.next();

        LocalDate dataContratacao;
        if(data.equalsIgnoreCase("NULL")){
            dataContratacao = null;
        } else {
            dataContratacao = LocalDate.parse(data, formatter);
        }

        List<Funcionario> funcionarios = funcionarioRepository.findAll(Specification
                .where(SpecificationFuncionario.nome(nome))
                .or(SpecificationFuncionario.cpf(cpf))
                .or(SpecificationFuncionario.salario(salario))
                .or(SpecificationFuncionario.dataContratacao(dataContratacao))
        );
        funcionarios.forEach(System.out::println);
    }
}
