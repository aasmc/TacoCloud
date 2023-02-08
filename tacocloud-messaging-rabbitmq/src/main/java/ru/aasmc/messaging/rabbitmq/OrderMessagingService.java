package ru.aasmc.messaging.rabbitmq;

import ru.aasmc.tacocloud.model.TacoOrder;

public interface OrderMessagingService {
    void sendOrder(TacoOrder order);
}
