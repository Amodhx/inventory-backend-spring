package org.example.inventorybackendspring.service;

import org.example.inventorybackendspring.dto.impl.ItemDTO;

import java.util.List;

public interface ItemService {
    List<ItemDTO> getAllItems();
    ItemDTO getItemById(String id);
    void saveItem(ItemDTO itemDTO);
}
