package com.bhmo.spring.data;

import com.bhmo.spring.data.model.Cargo;
import com.bhmo.spring.data.repository.CargoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

    private final CargoRepository repository;

    public SpringDataApplication(CargoRepository repository) {
        this.repository = repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {
        Cargo cargo = new Cargo();
        cargo.setDescricao("Desenvolvedor Java");

        repository.save(cargo);
    }

}
