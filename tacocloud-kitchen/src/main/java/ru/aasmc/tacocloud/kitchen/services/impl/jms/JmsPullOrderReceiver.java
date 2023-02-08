package ru.aasmc.tacocloud.kitchen.services.impl.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import ru.aasmc.tacocloud.kitchen.model.TacoOrder;
import ru.aasmc.tacocloud.kitchen.services.OrderReceiver;

@Profile("jms-template")
@Component
public class JmsPullOrderReceiver implements OrderReceiver {

    private final JmsTemplate jms;

    @Autowired
    public JmsPullOrderReceiver(JmsTemplate jms) {
        this.jms = jms;
    }

    @Override
    public TacoOrder receiveOrder() {
        return (TacoOrder) jms.receiveAndConvert("tacocloud.order.queue");
    }
}
