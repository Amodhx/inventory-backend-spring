package org.example.inventorybackendspring.controller;


import org.example.inventorybackendspring.dao.OrderDAO;
import org.example.inventorybackendspring.dao.OrderItemDAO;
import org.example.inventorybackendspring.dto.impl.OrderDTO;
import org.example.inventorybackendspring.dto.impl.Order_detailDTO;
import org.example.inventorybackendspring.util.GenerateId;
import org.example.inventorybackendspring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/transaction")
public class TransactionalController {

    @Autowired
    OrderDAO orderDAO;

    @Autowired
    OrderItemDAO orderItemDAO;

    @Autowired
    Mapping mapping;
    @PostMapping
    public void saveOrdersAndOrderItems(@RequestBody () List<Order_detailDTO> orderDetailDTO , @RequestHeader("obj1")OrderDTO orderDTO){
            orderDTO.setOrder_id(GenerateId.getOrderId());
            orderDAO.save(mapping.toOrderEntity(orderDTO));

        for (int i = 0; i < orderDetailDTO.size(); i++) {
            orderDetailDTO.get(i).setOrderItem_id(GenerateId.getOrderItemID());
            orderItemDAO.save(mapping.toOrderItemEntity(orderDetailDTO.get(i)));
        }

    }
}
