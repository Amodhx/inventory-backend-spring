package org.example.inventorybackendspring.dao;

import org.example.inventorybackendspring.entity.impl.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDAO extends JpaRepository<OrderEntity,String> {
}
