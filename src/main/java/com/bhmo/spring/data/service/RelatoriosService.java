package com.bhmo.spring.data.service;

import com.bhmo.spring.data.model.Funcionario;
import com.bhmo.spring.data.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Service
public class RelatoriosService {

    private Boolean system = true;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final FuncionarioRepository funcionarioRepository;

    public RelatoriosService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void iniciar(Scanner scanner){
        while (system){
            System.out.println("Escolha uma função:");
            System.out.println("0 - Sair");
            System.out.println("1 - Busca funcionário por Nome");
            System.out.println("2 - Busca funcionário por Nome, Data de Contratação e Salario Maior que");

            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    buscaFuncionarioPorNome(scanner);
                    break;
                case 2:
                    buscaFuncionarioNomeSalarioMAiorData(scanner);
                    break;
                default:
                    system = false;
                    break;
            }
        }
    }

    private void buscaFuncionarioPorNome(Scanner scanner) {
        System.out.println("Qual nome deseja pesquisar?");
        String nome = scanner.nextLine().toUpperCase();
        nome += scanner.nextLine().toUpperCase();

        List<Funcionario> funcionarios = funcionarioRepository.findByNome(nome);

        funcionarios.forEach(System.out::println);
    }

    private void buscaFuncionarioNomeSalarioMAiorData(Scanner scanner) {
        System.out.println("Qual nome deseja pesquisar?");
        String nome = scanner.nextLine().toUpperCase();
        nome += scanner.nextLine().toUpperCase();

        System.out.println("Qual data deseja pesquisar?");
        String data = scanner.next();
        LocalDate localDate = LocalDate.parse(data, formatter);

        System.out.println("Qual salario deseja pesquisar?");
        Double salario = scanner.nextDouble();

        List<Funcionario> funcionarios = funcionarioRepository.findNomeDataSalarioMaiorQue(nome, salario, localDate);
        funcionarios.forEach(System.out::println);
    }
}
