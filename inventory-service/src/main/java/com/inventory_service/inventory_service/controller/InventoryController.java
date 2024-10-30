package com.inventory_service.inventory_service.controller;

import com.inventory_service.inventory_service.model.Product;
import com.inventory_service.inventory_service.service.InventoryService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @Operation(summary = "Get all products", description = "Retrieve a list of all products in the inventory")
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return inventoryService.getAllProducts();
    }

    @Operation(summary = "Get a product by ID", description = "Retrieve a specific product by its ID")
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        Product product = inventoryService.getProductById(id);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    @Operation(summary = "Add a new product", description = "Add a new product to the inventory")
    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return inventoryService.addProduct(product);
    }

    @Operation(summary = "Update a product by ID", description = "Update the details of an existing product")
    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody Product productDetails) {
        Product updatedProduct = inventoryService.updateProduct(id, productDetails);
        if (updatedProduct == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedProduct);
    }

    @Operation(summary = "Delete a product by ID", description = "Delete a specific product from the inventory")
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        inventoryService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
