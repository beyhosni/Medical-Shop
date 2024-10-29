package com.api_gateway.config;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("auth-service", r -> r
                .path("/auth/**")
                .uri("lb://auth-service"))
            .route("product-service", r -> r
                .path("/products/**")
                .uri("lb://product-service"))
            .route("order-service", r -> r
                .path("/orders/**")
                .uri("lb://order-service"))
            .route("inventory-service", r -> r
                .path("/inventory/**")
                .uri("lb://inventory-service"))
            .route("notification-service", r -> r
                .path("/notifications/**")
                .uri("lb://notification-service"))
            .build();
    }
    
}
