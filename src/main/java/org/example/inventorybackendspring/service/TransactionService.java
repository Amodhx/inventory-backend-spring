package org.example.inventorybackendspring.service;

import org.example.inventorybackendspring.dto.impl.OrderAndOrderDetailsDTO;
import org.example.inventorybackendspring.dto.impl.OrderDTO;
import org.example.inventorybackendspring.dto.impl.Order_detailDTO;

import java.util.List;

public interface TransactionService {

    void saveTransaction(OrderAndOrderDetailsDTO orderAndOrderDetailsDTO);
}
