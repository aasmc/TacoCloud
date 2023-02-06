package ru.aasmc.tacocloud.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.aasmc.tacocloud.data.IngredientRepository;
import ru.aasmc.tacocloud.model.Ingredient;
import ru.aasmc.tacocloud.model.IngredientCollection;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(path = "/api/ingredients", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:8080")
public class IngredientApiController {

    private final IngredientRepository repository;

    @Autowired
    public IngredientApiController(IngredientRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public IngredientCollection allIngredients() {
        Iterable<Ingredient> all = repository.findAll();
        List<Ingredient> list = StreamSupport.stream(all.spliterator(), false)
                .collect(Collectors.toList());
        return new IngredientCollection(list);
    }

}
