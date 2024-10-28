package com.example.inventory_service.service;

import com.example.inventory_service.dto.InventoryResponse;

import java.util.List;

public interface InventoryService {
    List<InventoryResponse> checkItemExistence(List<String> itemCodes);
}
