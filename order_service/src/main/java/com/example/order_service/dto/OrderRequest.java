package com.example.order_service.dto;

import com.example.order_service.model.OrderLineItems;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderRequest {
    String orderNumber;
    List<OrderLineItemsDto> orderLineItemsDtoList;
}
