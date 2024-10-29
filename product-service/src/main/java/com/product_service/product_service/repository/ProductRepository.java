package com.product_service.product_service.repository;

import com.product_service.product_service.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
    // Les méthodes de base CRUD sont automatiquement implémentées
}
