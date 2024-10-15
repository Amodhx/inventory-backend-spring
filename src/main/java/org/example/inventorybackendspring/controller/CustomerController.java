package org.example.inventorybackendspring.controller;

import org.example.inventorybackendspring.customStatusCodes.SelectedCustomerErrorStatus;
import org.example.inventorybackendspring.dto.impl.CustomerDTO;
import org.example.inventorybackendspring.dto.status.CustomerStatus;
import org.example.inventorybackendspring.exception.DataNotFoundException;
import org.example.inventorybackendspring.exception.DataPersistException;
import org.example.inventorybackendspring.responce.CustomerResponse;
import org.example.inventorybackendspring.service.CustomerService;
import org.example.inventorybackendspring.util.GenerateId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {

    static Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    CustomerService customerService;
    @GetMapping
    public List<CustomerDTO> getAllCustomers(){
        logger.info("Customer Data Retriv!");
        return customerService.getAllCustomer();
    }
    @GetMapping(value = "/{customer_id}")
    public CustomerStatus getCustomerByID(@PathVariable ("customer_id") String customer_id){
        if (customer_id != null) {
            try {
                return customerService.getCustomerById(customer_id);
            } catch (DataNotFoundException e) {
                return new SelectedCustomerErrorStatus(1, "Cant find Customer");
            } catch (Exception e) {
                return new CustomerResponse(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }else {
            return new SelectedCustomerErrorStatus(2,"Customer_Id is Empty!");
        }
    }

    @PostMapping
    public ResponseEntity<Void> saveCustomer(@RequestBody() CustomerDTO customerDTO){
        try {
            customerDTO.setCustomer_id(GenerateId.getCustomerId());
            customerService.saveCustomer(customerDTO);
            logger.info("Customer Data saved!" + customerDTO.getCustomer_id());
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping
    public CustomerStatus updateCustomer(@RequestBody() CustomerDTO customerDTO){
        if (customerDTO != null){
            try {
                System.out.println(customerDTO.getCustomer_id());
                customerService.updateCustomer(customerDTO);

                logger.info("Customer Data updated"+customerDTO.getCustomer_id());
                return new CustomerResponse(HttpStatus.CREATED);
            }catch (DataNotFoundException e){
                return new CustomerResponse(HttpStatus.BAD_REQUEST);
            }catch (Exception e){
                e.printStackTrace();
                return new CustomerResponse(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }else {
            return new SelectedCustomerErrorStatus(3,"Customer Values are Null");
        }
    }

    @DeleteMapping(value = "/{customer_id}")
    public CustomerStatus deleteCustomer(@PathVariable("customer_id") String customer_id){
        try {
            customerService.deleteCustomer(customer_id);
            logger.info("Customer Data deleted"+ customer_id);
            return new CustomerResponse(HttpStatus.CREATED);
        }catch (DataNotFoundException e){
            return new CustomerResponse(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new CustomerResponse(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
