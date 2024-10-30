package com.yourcompany.inventory.repository;

import com.yourcompany.inventory.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    // Ajoutez des méthodes personnalisées si nécessaire
}

