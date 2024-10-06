package org.example.inventorybackendspring.customStatusCodes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.inventorybackendspring.dto.status.CustomerStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectedCustomerErrorStatus implements CustomerStatus {
    private int status;
    private String message;
}
