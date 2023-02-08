package ru.aasmc.tacocloud.kitchen.services.impl.jms;

import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import ru.aasmc.tacocloud.kitchen.model.TacoOrder;
import ru.aasmc.tacocloud.kitchen.ui.KitchenUI;

@Profile("jms-listener")
@Component
public class JmsPushOrderListener {
    private final KitchenUI ui;


    public JmsPushOrderListener(KitchenUI ui) {
        this.ui = ui;
    }

    @JmsListener(destination = "tacocloud.order.queue")
    public void receiveOrder(TacoOrder order) {
        ui.displayOrder(order);
    }
}
