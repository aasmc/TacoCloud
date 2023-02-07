package ru.aasmc.tacocloud.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.aasmc.tacocloud.data.TacoRepository;
import ru.aasmc.tacocloud.model.Taco;
import ru.aasmc.tacocloud.model.TacoCollection;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/tacos", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:8080")
public class TacoApiController {

    private final TacoRepository tacoRepository;

    @Autowired
    public TacoApiController(TacoRepository tacoRepository) {
        this.tacoRepository = tacoRepository;
    }

    @GetMapping(params = "recent")
    public TacoCollection recentTacos() {
        PageRequest page = PageRequest.of(0, 12, Sort.by("createdAt").descending());
        return new TacoCollection(tacoRepository.findAll(page).getContent());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Taco postTaco(@RequestBody Taco taco) {
        return tacoRepository.save(taco);
    }

/*    @GetMapping("/{id}")
    public ResponseEntity<Taco> tacoByIdEntity(@PathVariable("id") Long id) {
        Optional<Taco> optionalTaco = tacoRepository.findById(id);
        return ResponseEntity.of(optionalTaco);
    }*/

    @GetMapping("/{id}")
    public Taco tacoById(@PathVariable("id") Long id) {
        Optional<Taco> byId = tacoRepository.findById(id);
        return byId.orElse(null);
    }
}
