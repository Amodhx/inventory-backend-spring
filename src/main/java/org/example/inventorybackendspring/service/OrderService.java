package org.example.inventorybackendspring.service;

import org.example.inventorybackendspring.dto.impl.OrderDTO;

import java.util.List;

public interface OrderService {
    void saveOrder(OrderDTO orderDTO);
    List<OrderDTO> getAllOrders();
}
