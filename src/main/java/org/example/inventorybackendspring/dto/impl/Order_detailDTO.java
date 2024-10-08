package org.example.inventorybackendspring.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.inventorybackendspring.dto.SuperDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order_detailDTO implements SuperDTO {
    private String orderItem_id;
    private String order_id;
    private String item_id;
    private String qty;
    private String price;
}
