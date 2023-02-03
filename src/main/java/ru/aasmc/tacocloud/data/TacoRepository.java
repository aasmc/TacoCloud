package ru.aasmc.tacocloud.data;

import org.springframework.data.repository.CrudRepository;
import ru.aasmc.tacocloud.model.Taco;

public interface TacoRepository
        extends CrudRepository<Taco, Long> {

}
