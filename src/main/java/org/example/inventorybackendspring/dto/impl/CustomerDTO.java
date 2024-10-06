package org.example.inventorybackendspring.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.inventorybackendspring.dto.SuperDTO;
import org.example.inventorybackendspring.dto.status.CustomerStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO implements CustomerStatus {
    private String customer_id;
    private String name;
    private String address;
    private String contact_number;
    private String date;

}
