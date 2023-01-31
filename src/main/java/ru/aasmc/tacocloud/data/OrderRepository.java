package ru.aasmc.tacocloud.data;

import ru.aasmc.tacocloud.TacoOrder;

import java.util.Optional;

public interface OrderRepository {

    TacoOrder save(TacoOrder order);

    Optional<TacoOrder> findById(Long id);

}
