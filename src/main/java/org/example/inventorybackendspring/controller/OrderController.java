package org.example.inventorybackendspring.controller;

import org.example.inventorybackendspring.dto.impl.OrderDTO;
import org.example.inventorybackendspring.exception.DataPersistException;
import org.example.inventorybackendspring.service.OrderService;
import org.example.inventorybackendspring.util.GenerateId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {

    @Autowired
    OrderService orderService;
    @PostMapping
    public ResponseEntity<Void> saveOrder(@RequestBody() OrderDTO orderDTO){
        orderDTO.setOrder_id(GenerateId.getOrderId());
        try {
            orderService.saveOrder(orderDTO);
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
