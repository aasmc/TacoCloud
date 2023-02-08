package ru.aasmc.tacocloud.kitchen.ui;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.aasmc.tacocloud.kitchen.model.TacoOrder;

@Component
@Slf4j
public class KitchenUI {
    public void displayOrder(TacoOrder order) {
        log.info("RECEIVED ORDER: " + order);
    }
}
