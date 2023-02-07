package ru.aasmc.tacocloud.data;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.aasmc.tacocloud.model.Taco;

public interface TacoRepository
        extends PagingAndSortingRepository<Taco, Long> {

}
