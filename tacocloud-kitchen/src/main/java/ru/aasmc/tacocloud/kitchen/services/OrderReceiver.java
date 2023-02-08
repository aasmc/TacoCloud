package ru.aasmc.tacocloud.kitchen.services;


import ru.aasmc.tacocloud.kitchen.model.TacoOrder;

public interface OrderReceiver {
    TacoOrder receiveOrder();
}
