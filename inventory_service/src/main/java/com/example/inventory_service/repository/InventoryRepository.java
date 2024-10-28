package com.example.inventory_service.repository;

import com.example.inventory_service.model.Inventory;
import com.fasterxml.jackson.databind.introspect.AnnotationCollector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long> {
    Optional<Inventory> findByItemCode(String itemCoe);

    List<Inventory> findByItemCodeIn(List<String> itemCode);
}
