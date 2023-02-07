package ru.aasmc.tacocloud.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import ru.aasmc.tacocloud.model.Ingredient;

@CrossOrigin(origins="http://localhost:8080")
public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
