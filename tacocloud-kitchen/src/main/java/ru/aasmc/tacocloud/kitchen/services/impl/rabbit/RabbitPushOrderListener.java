package ru.aasmc.tacocloud.kitchen.services.impl.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ru.aasmc.tacocloud.kitchen.model.TacoOrder;
import ru.aasmc.tacocloud.kitchen.ui.KitchenUI;

@Profile("rabbitmq-listener")
@Component
public class RabbitPushOrderListener {
    private final KitchenUI ui;

    @Autowired
    public RabbitPushOrderListener(KitchenUI ui) {
        this.ui = ui;
    }

    @RabbitListener(queues = "tacocloud.order.queues")
    public void receiveOrder(TacoOrder order) {
        ui.displayOrder(order);
    }
}
