package com.example.order_service.service;


import com.example.order_service.dto.InventoryResponse;
import com.example.order_service.dto.OrderLineItemsDto;
import com.example.order_service.dto.OrderRequest;
import com.example.order_service.mapper.OrderMapper;
import com.example.order_service.model.Order;
import com.example.order_service.model.OrderLineItems;
import com.example.order_service.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;

    @Override
    public String addOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(OrderMapper::dtoToModel).toList();
        order.setOrderLineItemsList(orderLineItems);

        List<String> itemCodes = order.getOrderLineItemsList().stream().map(OrderLineItems::getItemCode).toList();

        InventoryResponse[] inventoryResponses = webClientBuilder.build().get()
                .uri("http://CN-PR-249.cybernet.az:8086/api/v1/inventory/get-inventory", uriBuilder -> uriBuilder.queryParam("itemCodes", itemCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();


//        assert inventoryResponses != null;
        if (inventoryResponses != null) {
            boolean allInStock = Arrays.stream(inventoryResponses).allMatch(InventoryResponse::isInStock);
            if (allInStock) {
                orderRepository.save(order);
                return "Ordered Successfully";
            }
        }
        return "no";
    }

}
