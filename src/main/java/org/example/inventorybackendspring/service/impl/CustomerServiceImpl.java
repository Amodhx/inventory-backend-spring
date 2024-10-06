package org.example.inventorybackendspring.service.impl;

import jakarta.transaction.Transactional;
import org.example.inventorybackendspring.dao.CustomerDAO;
import org.example.inventorybackendspring.dto.impl.CustomerDTO;
import org.example.inventorybackendspring.entity.impl.CustomerEntity;
import org.example.inventorybackendspring.exception.DataNotFoundException;
import org.example.inventorybackendspring.exception.DataPersistException;
import org.example.inventorybackendspring.service.CustomerService;
import org.example.inventorybackendspring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    Mapping mapping;

    @Autowired
    CustomerDAO customerDAO;


    @Override
    public List<CustomerDTO> getAllCustomer() {
        if (customerDAO.count() > 0) {
            return mapping.toCustomerDTOList(customerDAO.findAll());
        }else {
            return new ArrayList<CustomerDTO>();
        }
    }

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        if (!customerDAO.existsById(customerDTO.getCustomer_id())) {
            customerDAO.save(mapping.toCustomerEntity(customerDTO));
        }else {
            throw new DataPersistException("Cant save Data");
        }
    }

    @Override
    public CustomerDTO getCustomerById(String customer_id) {
        if (customerDAO.existsById(customer_id)) {
            return mapping.toCustomerDTO(customerDAO.getReferenceById(customer_id));
        }else {
            throw new DataNotFoundException("Cant Find Data");
        }
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {
        if (customerDAO.existsById(customerDTO.getCustomer_id())) {
            CustomerEntity customer = customerDAO.getReferenceById(customerDTO.getCustomer_id());
            customer.setAddress(customerDTO.getAddress());
            customer.setName(customerDTO.getName());
            customer.setDate(customerDTO.getDate());
            customer.setContact_number(customerDTO.getContact_number());
        }else {
            throw new DataNotFoundException("Cant Find Customer to Update");
        }
    }

    @Override
    public void deleteCustomer(String customer_id) {
        if (customerDAO.existsById(customer_id)) {
            customerDAO.deleteById(customer_id);
        }else {
            throw new DataNotFoundException("Cant Find Customer to Delete!");
        }
    }


}
