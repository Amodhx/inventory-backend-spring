package org.example.inventorybackendspring.service.impl;

import jakarta.transaction.Transactional;
import org.example.inventorybackendspring.dao.OrderItemDAO;
import org.example.inventorybackendspring.dto.impl.OrderDTO;
import org.example.inventorybackendspring.dto.impl.Order_detailDTO;
import org.example.inventorybackendspring.service.OrderItemService;
import org.example.inventorybackendspring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    Mapping mapping;

    @Autowired
    OrderItemDAO orderItemDAO;

    @Override
    public void saveOrderItems(List<Order_detailDTO> list) {
        for (int i = 0; i < list.size(); i++) {
            orderItemDAO.save(mapping.toOrderItemEntity(list.get(i)));
        }

    }
}
