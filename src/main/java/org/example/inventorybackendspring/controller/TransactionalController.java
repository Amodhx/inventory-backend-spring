package org.example.inventorybackendspring.controller;


import org.example.inventorybackendspring.dao.OrderDAO;
import org.example.inventorybackendspring.dao.OrderItemDAO;
import org.example.inventorybackendspring.dto.impl.OrderAndOrderDetailsDTO;
import org.example.inventorybackendspring.dto.impl.OrderDTO;
import org.example.inventorybackendspring.dto.impl.Order_detailDTO;
import org.example.inventorybackendspring.service.TransactionService;
import org.example.inventorybackendspring.util.GenerateId;
import org.example.inventorybackendspring.util.Mapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/transaction")
@CrossOrigin
public class TransactionalController {

    Logger logger = LoggerFactory.getLogger(TransactionalController.class);
    @Autowired
    TransactionService transactionService;
    @PostMapping
    public ResponseEntity<Void> saveOrdersAndOrderItems(@RequestBody() OrderAndOrderDetailsDTO orderAndOrderDetailsDTO){

        String orderId = GenerateId.getOrderId();
        orderAndOrderDetailsDTO.setOrder_id(orderId);
        for (int i = 0; i < orderAndOrderDetailsDTO.getList().size(); i++) {
            orderAndOrderDetailsDTO.getList().get(i).setOrderItem_id(GenerateId.getOrderItemID());
            orderAndOrderDetailsDTO.getList().get(i).setOrder_id(orderId);
        }
        try {
            transactionService.saveTransaction(orderAndOrderDetailsDTO);
            logger.info("Save Transaction Order and order details !");
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
