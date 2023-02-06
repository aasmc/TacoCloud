package ru.aasmc.tacocloud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.aasmc.tacocloud.data.IngredientRepository;
import ru.aasmc.tacocloud.model.Ingredient;

import static ru.aasmc.tacocloud.model.Ingredient.*;

@SpringBootApplication
public class TacoCloundApplication {

    public static void main(String[] args) {
        SpringApplication.run(TacoCloundApplication.class, args);
    }
}
