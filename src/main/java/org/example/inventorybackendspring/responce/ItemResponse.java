package org.example.inventorybackendspring.responce;

import org.example.inventorybackendspring.dto.status.ItemStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

public class ItemResponse extends ResponseEntity<Void> implements ItemStatus {
    public ItemResponse(HttpStatusCode status) {
        super(status);
    }
}
