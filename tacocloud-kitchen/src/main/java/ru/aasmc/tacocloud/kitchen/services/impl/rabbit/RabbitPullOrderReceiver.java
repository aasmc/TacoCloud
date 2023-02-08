package ru.aasmc.tacocloud.kitchen.services.impl.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ru.aasmc.tacocloud.kitchen.model.TacoOrder;
import ru.aasmc.tacocloud.kitchen.services.OrderReceiver;

@Profile("rabbitmq-template")
@Component("templateOrderReceiver")
public class RabbitPullOrderReceiver implements OrderReceiver {

    private final RabbitTemplate rabbit;

    @Autowired
    public RabbitPullOrderReceiver(RabbitTemplate rabbit) {
        this.rabbit = rabbit;
    }

    @Override
    public TacoOrder receiveOrder() {
        return (TacoOrder) rabbit.receiveAndConvert("tacocloud.order.queue");
    }
}
