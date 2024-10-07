package org.example.inventorybackendspring.service.impl;

import jakarta.transaction.Transactional;
import org.example.inventorybackendspring.dao.ItemDAO;
import org.example.inventorybackendspring.dto.impl.ItemDTO;
import org.example.inventorybackendspring.exception.DataNotFoundException;
import org.example.inventorybackendspring.exception.DataPersistException;
import org.example.inventorybackendspring.service.ItemService;
import org.example.inventorybackendspring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemDAO itemDAO;
    @Autowired
    Mapping mapping;
    @Override
    public List<ItemDTO> getAllItems() {
        if (itemDAO.count() > 0) {
            return mapping.toItemDTOList(itemDAO.findAll());
        }else {
            return new ArrayList<>();
        }
    }

    @Override
    public ItemDTO getItemById(String id) {
        if (itemDAO.existsById(id)){
            return mapping.toItemDTO(itemDAO.getReferenceById(id));
        }else {
            throw new DataNotFoundException("Cant Find Item");
        }
    }

    @Override
    public void saveItem(ItemDTO itemDTO) {
        if (!itemDAO.existsById(itemDTO.getItem_id())){
            itemDAO.save(mapping.toItemEntity(itemDTO));
        }else {
            throw new DataPersistException("Cant Save Item Data");
        }
    }
}
