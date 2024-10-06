package org.example.inventorybackendspring.responce;

import org.example.inventorybackendspring.dto.status.CustomerStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class CustomerResponse extends ResponseEntity<Void> implements CustomerStatus {
    public CustomerResponse(HttpStatusCode status) {
        super(status);
    }


}
