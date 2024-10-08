package org.example.inventorybackendspring.dao;

import org.example.inventorybackendspring.entity.impl.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemDAO extends JpaRepository<OrderItemEntity,String> {
}
