package org.example.inventorybackendspring.util;

import org.example.inventorybackendspring.dto.impl.CustomerDTO;
import org.example.inventorybackendspring.dto.impl.ItemDTO;
import org.example.inventorybackendspring.dto.impl.OrderDTO;
import org.example.inventorybackendspring.entity.impl.CustomerEntity;
import org.example.inventorybackendspring.entity.impl.ItemEntity;
import org.example.inventorybackendspring.entity.impl.OrderEntity;
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

    public ItemDTO toItemDTO(ItemEntity item){
        return modelMapper.map(item, ItemDTO.class);
    }
    public ItemEntity toItemEntity(ItemDTO itemDTO){
        return modelMapper.map(itemDTO, ItemEntity.class);
    }
    public List<ItemDTO> toItemDTOList(List<ItemEntity> list){
        return modelMapper.map(list,new TypeToken<List<ItemDTO>>(){}.getType());
    }

    public OrderDTO toOrderDTO(OrderEntity entity){
        return modelMapper.map(entity, OrderDTO.class);
    }
    public OrderEntity toOrderEntity(OrderDTO orderDTO){
        return modelMapper.map(orderDTO, OrderEntity.class);
    }
    public List<OrderDTO> toOrderDTOList(List<OrderEntity> list){
        return modelMapper.map(list,new TypeToken<List<OrderDTO>>(){}.getType());
    }
}
