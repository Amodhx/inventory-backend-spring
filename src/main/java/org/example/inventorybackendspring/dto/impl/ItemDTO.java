package org.example.inventorybackendspring.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.inventorybackendspring.dto.SuperDTO;
import org.example.inventorybackendspring.dto.status.ItemStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO implements ItemStatus {
    private String item_id;
    private String product_name;
    private String buy_price;
    private String sel_price;
    private String expire_date;
    private String qty;
    private String brand;
}
