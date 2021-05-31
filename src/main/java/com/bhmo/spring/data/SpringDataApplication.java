package com.bhmo.spring.data;

import com.bhmo.spring.data.service.CrudCargoService;
import com.bhmo.spring.data.service.CrudFuncionarioService;
import com.bhmo.spring.data.service.CrudUnidadeTrabalhoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

    private final CrudCargoService cargoService;
    private final CrudFuncionarioService funcionarioService;
    private final CrudUnidadeTrabalhoService unidadeTrabalhoService;

    private Boolean system = true;

    public SpringDataApplication(CrudCargoService cargoService, CrudFuncionarioService funcionarioService, CrudUnidadeTrabalhoService unidadeTrabalhoService) {
        this.cargoService = cargoService;
        this.funcionarioService = funcionarioService;
        this.unidadeTrabalhoService = unidadeTrabalhoService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);

        while(system){
            System.out.println("Qual ação você quer executar? ");
            System.out.println("0 - Sair");
            System.out.println("1 - Cargos");
            System.out.println("2 - Cargo");
            System.out.println("3 - Unidade");

            int function = scanner.nextInt();

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
