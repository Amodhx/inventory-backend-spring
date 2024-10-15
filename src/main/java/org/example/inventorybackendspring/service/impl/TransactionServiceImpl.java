package org.example.inventorybackendspring.service.impl;

import jakarta.transaction.Transactional;
import org.example.inventorybackendspring.dao.ItemDAO;
import org.example.inventorybackendspring.dao.OrderDAO;
import org.example.inventorybackendspring.dao.OrderItemDAO;
import org.example.inventorybackendspring.dto.impl.OrderAndOrderDetailsDTO;
import org.example.inventorybackendspring.dto.impl.OrderDTO;
import org.example.inventorybackendspring.dto.impl.Order_detailDTO;
import org.example.inventorybackendspring.entity.impl.ItemEntity;
import org.example.inventorybackendspring.entity.impl.OrderItemEntity;
import org.example.inventorybackendspring.service.TransactionService;
import org.example.inventorybackendspring.util.GenerateId;
import org.example.inventorybackendspring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    OrderDAO orderDAO;
    @Autowired
    OrderItemDAO orderItemDAO;

    @Autowired
    Mapping mapping;


    @Override
    public void saveTransaction(OrderAndOrderDetailsDTO orderAndOrderDetailsDTO) {
        orderDAO.save(mapping.toOrderEntity(new OrderDTO(
                orderAndOrderDetailsDTO.getOrder_id(),
                orderAndOrderDetailsDTO.getCustomer_id(),
                orderAndOrderDetailsDTO.getCustomer_name(),
                orderAndOrderDetailsDTO.getDate(),
                orderAndOrderDetailsDTO.getAmount(),
                orderAndOrderDetailsDTO.getType()
        )));
        for (int i = 0; i < orderAndOrderDetailsDTO.getList().size(); i++) {
            System.out.println(mapping.toOrderItemEntity(orderAndOrderDetailsDTO.getList().get(i)));
            orderItemDAO.save(mapping.toOrderItemEntity(orderAndOrderDetailsDTO.getList().get(i)));
        }



    }
}
