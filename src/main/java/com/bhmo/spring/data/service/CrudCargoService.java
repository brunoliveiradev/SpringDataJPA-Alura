package com.bhmo.spring.data.service;

import com.bhmo.spring.data.model.Cargo;
import com.bhmo.spring.data.repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

//Logica para fazer o CRUD no banco de dados
@Service
public class CrudCargoService {

    private Boolean system = true;
    private final CargoRepository cargoRepository;

    public CrudCargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public void iniciar(Scanner scanner){
        while (system){
            System.out.println("Escolha uma função:");
            System.out.println("0 - Sair");
            System.out.println("1 - Inserir novo Cargo");
            System.out.println("2 - Atualizar Cargo existente");
            System.out.println("3 - Visualizar todos os Cargos");
            System.out.println("4 - Deletar Cargo");

            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    salvar(scanner);
                    break;
                case 2:
                    atualizar(scanner);
                    break;
                case 3:
                    visualizar();
                    break;
                case 4:
                    deletar(scanner);
                    break;
                default:
                    system = false;
                    break;
            }
        }
    }

    private void salvar(Scanner scanner){
        System.out.print("Digite a Descrição do Cargo: ");
        String descricao = scanner.nextLine().toUpperCase();
        descricao += scanner.nextLine().toUpperCase();

        Cargo cargo = new Cargo();
        cargo.setDescricao(descricao);
        cargoRepository.save(cargo);

        System.out.println(descricao + " FOI SALVO!");
    }

    private void atualizar(Scanner scanner){
        System.out.print("Informe o ID que deseja atualizar: ");
        int id = scanner.nextInt();

        Cargo cargo;

        if (this.cargoRepository.findById(id).isPresent()) {
            cargo = this.cargoRepository.findById(id).get();
            System.out.println(cargo.getDescricao() + " LOCALIZADO!");

            System.out.print("Digite a nova descrição do cargo: ");
            String descricao = scanner.nextLine().toUpperCase();
            descricao += scanner.nextLine().toUpperCase();
            cargo.setDescricao(descricao);

            this.cargoRepository.save(cargo);
            System.out.println(descricao + " SALVO NO ID: " + id + "!");
        } else {
            System.out.println("Ação cancelada, ID inválido!");
        }
    }

    private void visualizar() {
        Iterable<Cargo> cargos = cargoRepository.findAll();
        cargos.forEach(System.out::println);
    }

    private void deletar(Scanner scanner) {
        System.out.print("Informe o ID que deseja deletar: ");
        int id = scanner.nextInt();

        Cargo cargo;
        if (this.cargoRepository.findById(id).isPresent()) {
            cargo = this.cargoRepository.findById(id).get();
            System.out.println("DESEJA DELETAR O CARGO: " + cargo.getDescricao() + " ?");
            System.out.println("0 - Cancelar");
            System.out.println("1 - Confirmar");

            int action = scanner.nextInt();
            if (action == 0) {
                System.out.println("Ação cancelada!");
            } if (action == 1) {
                this.cargoRepository.deleteById(id);
                System.out.println("Ação concluída!");
            }
        } else {
            System.out.println("Ação cancelada, ID inválido!");
        }
    }
}
