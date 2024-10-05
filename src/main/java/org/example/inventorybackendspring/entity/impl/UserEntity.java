package org.example.inventorybackendspring.entity.impl;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.inventorybackendspring.entity.SuperEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity implements SuperEntity {
    @Id
    private String user_id;
    @Column(unique = true,nullable = false)
    private String user_name;
    @Column(unique = true,nullable = false)
    private String password;
}
