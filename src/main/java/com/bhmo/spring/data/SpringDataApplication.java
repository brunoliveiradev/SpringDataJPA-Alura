package com.bhmo.spring.data;

import com.bhmo.spring.data.service.CrudCargoService;
import com.bhmo.spring.data.service.CrudFuncionarioService;
import com.bhmo.spring.data.service.CrudUnidadeTrabalhoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Scanner;

@EnableJpaRepositories
@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

    private Boolean system = true;

    private final CrudCargoService cargoService;

    private final CrudFuncionarioService funcionarioService;

    private final CrudUnidadeTrabalhoService unidadeTrabalhoService;

    public SpringDataApplication(CrudCargoService cargoService,
                                 CrudFuncionarioService funcionarioService,
                                 CrudUnidadeTrabalhoService unidadeTrabalhoService) {
        this.cargoService = cargoService;
        this.funcionarioService = funcionarioService;
        this.unidadeTrabalhoService = unidadeTrabalhoService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (system) {
            System.out.println("Qual função deseja executar?");
            System.out.println("0 - Sair");
            System.out.println("1 - Cargo");
            System.out.println("2 - Funcionário");
            System.out.println("3 - Unidade");

            Integer function = scanner.nextInt();

            switch (function) {
                case 1:
                    cargoService.iniciar(scanner);
                    break;
                case 2:
                    funcionarioService.iniciar(scanner);
                    break;
                case 3:
                    unidadeTrabalhoService.iniciar(scanner);
                    break;
                default:
                    System.out.println("Finalizando");
                    system = false;
                    break;
            }
        }
    }
}
