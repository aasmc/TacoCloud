package ru.aasmc.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import ru.aasmc.tacocloud.model.TacoOrder;

import javax.jms.JMSException;
import javax.jms.Message;

@Service
public class JmsMessagingService implements OrderMessagingService {

    private final JmsTemplate jms;


    @Autowired
    public JmsMessagingService(JmsTemplate jms) {
        this.jms = jms;
    }

    @Override
    public void sendOrder(TacoOrder order) {
        jms.convertAndSend("tacocloud.order.queue", order, this::addOrderSource);
    }

    private Message addOrderSource(Message message) throws JMSException {
        message.setStringProperty("X_ORDER_SOURCE", "WEB");
        return message;
    }
}
