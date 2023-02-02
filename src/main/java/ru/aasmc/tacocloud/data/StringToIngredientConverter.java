package ru.aasmc.tacocloud.data;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.aasmc.tacocloud.Ingredient;
import ru.aasmc.tacocloud.IngredientUDT;

import java.util.Optional;

@Component
public class StringToIngredientConverter implements Converter<String, IngredientUDT> {

    private IngredientRepository ingredientRepository;

    public StringToIngredientConverter(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public IngredientUDT convert(String s) {
        Optional<Ingredient> byId = ingredientRepository.findById(s);
        if (byId.isEmpty()) {
            return null;
        }
        return byId.map(i -> {
            return new IngredientUDT(i.getName(), i.getType());
        }).get();
    }
}
