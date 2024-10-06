package org.example.inventorybackendspring.dao;

import org.example.inventorybackendspring.entity.impl.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDAO extends JpaRepository<ItemEntity,String> {
}
