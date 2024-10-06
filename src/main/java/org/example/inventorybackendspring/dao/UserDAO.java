package org.example.inventorybackendspring.dao;

import org.example.inventorybackendspring.entity.impl.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<UserEntity,String> {
}
