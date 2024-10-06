package org.example.inventorybackendspring.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class DataNotFoundException extends RuntimeException{
    public DataNotFoundException() {
        super();
    }

    public DataNotFoundException(String message) {
        super(message);
    }

    public DataNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
