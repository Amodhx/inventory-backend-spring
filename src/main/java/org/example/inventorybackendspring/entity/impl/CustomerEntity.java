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
@Table(name = "customer")
public class CustomerEntity implements SuperEntity {
    @Id
    private String customer_id;
    private String name;
    private String address;
    private String contact_number;
    private String date;
    @OneToMany(mappedBy = "customer")
    private List<OrderEntity> orders;

}
