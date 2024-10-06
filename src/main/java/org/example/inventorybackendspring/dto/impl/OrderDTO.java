package org.example.inventorybackendspring.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.inventorybackendspring.dto.SuperDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO implements SuperDTO {
    private String order_id;
    private String customer_id;
    private String customer_name;
    private String date;
    private String amount;
    private String type;
}
