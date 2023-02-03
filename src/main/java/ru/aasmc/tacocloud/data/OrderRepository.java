package ru.aasmc.tacocloud.data;

import org.springframework.data.repository.CrudRepository;
import ru.aasmc.tacocloud.TacoOrder;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends CrudRepository<TacoOrder, String> {
    List<TacoOrder> findByDeliveryZip(String deliveryZip);

    List<TacoOrder> readOrdersByDeliveryZipAndPlacedAtBetween(String deliveryZip, Date startDate, Date endDate);

    List<TacoOrder> findByDeliveryNameAndDeliveryCityAllIgnoringCase(String deliveryName, String deliveryCity);
}
