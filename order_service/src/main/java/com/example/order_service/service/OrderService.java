package com.example.order_service.service;

import com.example.order_service.dto.OrderRequest;

public interface OrderService {
    String  addOrder(OrderRequest orderRequest);
}
