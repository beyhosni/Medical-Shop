package com.order_service.order_service.service;

import com.order_service.order_service.exception.OrderNotFoundException;
import com.order_service.order_service.model.Order;
import com.order_service.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(String id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with ID: " + id));
    }

    public Order createOrder(Order order) {
        // Logique pour calculer le prix total de la commande et vérifier les stocks dans product-service
        return orderRepository.save(order);
    }

    public Order updateOrder(String id, Order order) {
        Order existingOrder = getOrderById(id);
        existingOrder.setStatus(order.getStatus());
        return orderRepository.save(existingOrder);
    }

    public void deleteOrder(String id) {
        orderRepository.deleteById(id);
    }
}
