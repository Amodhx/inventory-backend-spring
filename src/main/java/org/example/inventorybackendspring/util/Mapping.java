package org.example.inventorybackendspring.util;

import org.example.inventorybackendspring.dto.impl.CustomerDTO;
import org.example.inventorybackendspring.entity.impl.CustomerEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {

    @Autowired
    ModelMapper modelMapper;
    public CustomerEntity toCustomerEntity(CustomerDTO customerDTO){
        return modelMapper.map(customerDTO,CustomerEntity.class);
    }
    public CustomerDTO toCustomerDTO(CustomerEntity customer){
        return modelMapper.map(customer, CustomerDTO.class);
    }
    public List<CustomerDTO> toCustomerDTOList(List<CustomerEntity> customerEntityList){
        return modelMapper.map(customerEntityList,new TypeToken<List<CustomerDTO>>(){}.getType());
    }
}
