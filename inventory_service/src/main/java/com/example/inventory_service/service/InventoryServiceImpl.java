package com.example.inventory_service.service;

import com.example.inventory_service.dto.InventoryResponse;
import com.example.inventory_service.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    @Override
    public List<InventoryResponse> checkItemExistence(List<String> itemCodes) {
        return inventoryRepository.findByItemCodeIn(itemCodes).stream()
                .map(inventory -> InventoryResponse.builder()
                        .itemCode(inventory.getItemCode())
                        .isInStock(inventory.getQuantity()>0)
                        .build()).toList();
    }
}
