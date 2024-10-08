package org.example.inventorybackendspring.entity.impl;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.inventorybackendspring.entity.SuperEntity;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item")
public class ItemEntity implements SuperEntity {
    @Id
    private String item_id;
    private String product_name;
    private String buy_price;
    private String sel_price;
    private String expire_date;
    private String qty;
    private String brand;

    @OneToMany(mappedBy = "itemEntity")
    private List<OrderItemEntity> ordersItem;
}
