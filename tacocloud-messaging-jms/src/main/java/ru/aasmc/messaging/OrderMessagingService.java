package ru.aasmc.messaging;

import ru.aasmc.tacocloud.model.TacoOrder;

public interface OrderMessagingService {
    void sendOrder(TacoOrder order);
}
