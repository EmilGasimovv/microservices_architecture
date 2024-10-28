package com.example.order_service.mapper;

import com.example.order_service.dto.OrderLineItemsDto;
import com.example.order_service.model.OrderLineItems;

public class OrderMapper {
    public static OrderLineItems dtoToModel(OrderLineItemsDto orderLineItemsDto){
        return OrderLineItems.builder()
                .price(orderLineItemsDto.getPrice())
                .itemCode(orderLineItemsDto.getItemCode())
                .quantity(orderLineItemsDto.getQuantity())
                .build();
    }

    public static OrderLineItemsDto modelToDto(OrderLineItems orderLineItems){
        return OrderLineItemsDto.builder()
                .price(orderLineItems.getPrice())
                .itemCode(orderLineItems.getItemCode())
                .quantity(orderLineItems.getQuantity())
                .build();
    }
}
