package org.example.inventorybackendspring.service;

import org.example.inventorybackendspring.dto.impl.CustomerDTO;
import org.example.inventorybackendspring.dto.status.CustomerStatus;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getAllCustomer();
    void saveCustomer(CustomerDTO customerDTO);

    CustomerDTO getCustomerById(String customer_id);
    void updateCustomer(CustomerDTO customerDTO);
    void deleteCustomer(String customer_id);
}
