package com.example.inventory_service.controller;

import com.example.inventory_service.dto.InventoryResponse;
import com.example.inventory_service.service.InventoryService;
//import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/health-check")
    public String healthCheck(){
        return "Working";
    }

    @GetMapping("/get-inventory")
    public ResponseEntity<List<InventoryResponse>> checkItemExistence(@RequestParam("itemCodes") List<String> itemCodes){
        return ResponseEntity.ok(inventoryService.checkItemExistence(itemCodes));
    }

}
