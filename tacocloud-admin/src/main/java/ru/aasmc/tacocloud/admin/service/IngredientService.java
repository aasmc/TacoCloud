package ru.aasmc.tacocloud.admin.service;

import ru.aasmc.tacocloud.admin.model.Ingredient;

public interface IngredientService {
    Iterable<Ingredient> findAll();

    Ingredient addIngredient(Ingredient ingredient);
}
