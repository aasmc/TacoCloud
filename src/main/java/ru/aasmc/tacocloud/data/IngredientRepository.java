package ru.aasmc.tacocloud.data;

import org.springframework.data.repository.CrudRepository;
import ru.aasmc.tacocloud.model.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
