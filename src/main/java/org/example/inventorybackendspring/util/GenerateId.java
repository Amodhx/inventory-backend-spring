package org.example.inventorybackendspring.util;

import java.util.UUID;

public class GenerateId {
    public static String getCustomerId(){
        return "CUSTOMER-"+UUID.randomUUID();
    }
    public static String getItemId(){
        return "ITEM-"+UUID.randomUUID();
    }
    public static String getOrderId(){
        return "ORDER-"+UUID.randomUUID();
    }


}
