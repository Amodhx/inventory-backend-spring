package org.example.inventorybackendspring.controller;

import org.example.inventorybackendspring.dto.impl.OrderDTO;
import org.example.inventorybackendspring.exception.DataPersistException;
import org.example.inventorybackendspring.service.OrderService;
import org.example.inventorybackendspring.util.GenerateId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/order")
@CrossOrigin
public class OrderController {

    Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    OrderService orderService;
    @PostMapping
    public ResponseEntity<Void> saveOrder(@RequestBody() OrderDTO orderDTO){
        orderDTO.setOrder_id(GenerateId.getOrderId());
        try {
            orderService.saveOrder(orderDTO);
            logger.info("Order saved !!!!" + orderDTO.getOrder_id());
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public List<OrderDTO> getAllOrders(){
        return orderService.getAllOrders();
    }
}
