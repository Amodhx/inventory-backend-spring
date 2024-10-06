package org.example.inventorybackendspring.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.inventorybackendspring.dto.SuperDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements SuperDTO {
    private String user_id;
    private String user_name;
    private String password;
}
