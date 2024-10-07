package org.example.inventorybackendspring.customStatusCodes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.inventorybackendspring.dto.status.ItemStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectedItemErrorStatus implements ItemStatus {
    private int status;
    private String message;
}
