package ru.aasmc.messaging.kafka;

import ru.aasmc.tacocloud.model.TacoOrder;

public interface OrderMessageService {
    void sendOrder(TacoOrder order);
}
