package org.example.inventorybackendspring.service.impl;

import jakarta.transaction.Transactional;
import org.example.inventorybackendspring.dao.OrderDAO;
import org.example.inventorybackendspring.dto.impl.OrderDTO;
import org.example.inventorybackendspring.entity.impl.OrderEntity;
import org.example.inventorybackendspring.exception.DataPersistException;
import org.example.inventorybackendspring.service.OrderService;
import org.example.inventorybackendspring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDAO orderDAO;
    @Autowired
    Mapping mapping;
    @Override
    public void saveOrder(OrderDTO orderDTO) {
        if (!orderDAO.existsById(orderDTO.getOrder_id())) {
            orderDAO.save(mapping.toOrderEntity(orderDTO));
        }else {
            throw new DataPersistException("Cant Save Data");
        }

    }

    @Override
    public List<OrderDTO> getAllOrders() {
        if (orderDAO.count()>0) {
            return mapping.toOrderDTOList(orderDAO.findAll());
        }else {
            return new ArrayList<>();
        }
    }
}
