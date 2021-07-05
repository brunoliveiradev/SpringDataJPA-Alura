package com.bhmo.spring.data.service;

import com.bhmo.spring.data.model.Funcionario;
import com.bhmo.spring.data.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class RelatoriosService {

    private Boolean system = true;

    private final FuncionarioRepository funcionarioRepository;

    public RelatoriosService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void iniciar(Scanner scanner){
        while (system){
            System.out.println("Escolha uma função:");
            System.out.println("0 - Sair");
            System.out.println("1 - Busca funcionário por Nome");

            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    buscaFuncionarioPorNome(scanner);
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
}