package ru.aasmc.tacocloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import ru.aasmc.tacocloud.data.OrderRepository;

@Service
public class OrderAdminServiceImpl implements OrderAdminService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderAdminServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteAllOrders() {
        orderRepository.deleteAll();
    }
}
