package com.order_service.order_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String orderNumber;
    
    @Column(nullable = false)
    private String customerName;
    
    @Column(nullable = false)
    private String customerEmail;
    
    private String customerPhone;
    
    @Column(nullable = false)
    private String shippingAddress;
    
    private String billingAddress;
    
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    
    @Column(nullable = false)
    private LocalDateTime orderDate;
    
    private LocalDateTime deliveryDate;
    
    @Column(nullable = false)
    private BigDecimal subtotal;
    
    private BigDecimal taxAmount;
    
    private BigDecimal shippingCost;
    
    @Column(nullable = false)
    private BigDecimal totalAmount;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderItem> orderItems;
    
    @Column(length = 1000)
    private String notes;
    
    private String paymentMethod;
    
    private String paymentTransactionId;
    
    @Column(nullable = false)
    private boolean isPaid;
    
    private LocalDateTime paidAt;
    
    @Version
    private Long version;
}

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
    
    private String productId;
    
    private String productName;
    
    private Integer quantity;
    
    private BigDecimal unitPrice;
    
    private BigDecimal totalPrice;
}

@Getter
enum OrderStatus {
    PENDING("En attente"),
    CONFIRMED("Confirmée"),
    PAID("Payée"),
    PROCESSING("En cours de traitement"),
    SHIPPED("Expédiée"),
    DELIVERED("Livrée"),
    CANCELLED("Annulée"),
    REFUNDED("Remboursée");

    private final String libelle;

    OrderStatus(String libelle) {
        this.libelle = libelle;
    }
}
