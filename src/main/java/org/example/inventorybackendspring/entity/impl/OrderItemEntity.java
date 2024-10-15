package org.example.inventorybackendspring.entity.impl;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "order_items")
public class OrderItemEntity {
    @Id
    private String orderItem_id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private ItemEntity item;
    private String qty;
    private String price;
}
