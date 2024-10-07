package org.example.inventorybackendspring.controller;

import org.example.inventorybackendspring.customStatusCodes.SelectedItemErrorStatus;
import org.example.inventorybackendspring.dto.impl.ItemDTO;
import org.example.inventorybackendspring.dto.status.ItemStatus;
import org.example.inventorybackendspring.exception.DataNotFoundException;
import org.example.inventorybackendspring.exception.DataPersistException;
import org.example.inventorybackendspring.responce.ItemResponse;
import org.example.inventorybackendspring.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping
    public List<ItemDTO> getAllItems(){
        return itemService.getAllItems();
    }

    @GetMapping(value = "/{item_id}")
    public ItemStatus getItemById(@PathVariable ("item_id") String item_id){
        if (item_id != null) {
            try {
                return itemService.getItemById(item_id);
            }catch (DataNotFoundException e){
                return new ItemResponse(HttpStatus.BAD_REQUEST);
            }catch (Exception e){
                return new ItemResponse(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }else {
            return new SelectedItemErrorStatus(1,"Item Id is Empty!");
        }
    }

    @PostMapping
    public ResponseEntity<Void> saveItem(@RequestBody() ItemDTO itemDTO){
        try {
            itemService.saveItem(itemDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
