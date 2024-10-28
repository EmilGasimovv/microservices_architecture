package com.example.order_service.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Getter
@Setter
public class OrderLineItemsDto {
    Long id;
    String itemCode;
    BigDecimal price;
    Integer quantity;
}
