package com.example.api_gateway.routes;

import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicate;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class ServiceRoutes {
    @Bean
    public RouterFunction<ServerResponse> orderServiceRoute() {
        return GatewayRouterFunctions.route()
                .nest(RequestPredicates.path("api/v1/order"),
                        builder -> builder
                                .POST("/add-order", HandlerFunctions.http("http://localhost:8082/add-order"))
                                .GET("/health-check", HandlerFunctions.http("http://localhost:8082/health-check")))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> inventoryServiceRoute() {
        return GatewayRouterFunctions.route()
                .nest(RequestPredicates.path("api/v1/inventory"),
                        builder -> builder
                                .GET("/health-check", HandlerFunctions.http("http://localhost:8086/health-check")))
                .build();
    }
    @Bean
    public RouterFunction<ServerResponse> userServiceRoute() {
        return GatewayRouterFunctions.route()
                .nest(RequestPredicates.path("api/v1/user"),
                        builder -> builder
                                .GET("/health-check", HandlerFunctions.http("http://localhost:8081/health-check")))
                .build();
    }
}
