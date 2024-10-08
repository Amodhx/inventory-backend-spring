package org.example.inventorybackendspring.controller;

import jakarta.transaction.Transactional;
import org.example.inventorybackendspring.dto.impl.Order_detailDTO;
import org.example.inventorybackendspring.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/orderItem")
public class OrderItemController {

    @Autowired
    OrderItemService orderItemService;
    @PostMapping
   public ResponseEntity<Void> saveOrderItem(@RequestBody () List<Order_detailDTO> list){
        try {
            orderItemService.saveOrderItems(list);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
