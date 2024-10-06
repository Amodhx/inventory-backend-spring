package org.example.inventorybackendspring.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.inventorybackendspring.dto.SuperDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order_detailDTO implements SuperDTO {
    private int order_id;
    private int item_id;
}
