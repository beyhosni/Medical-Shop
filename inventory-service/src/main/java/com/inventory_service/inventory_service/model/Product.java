package com.inventory_service.inventory_service.model;

import lombok.Data;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "products")
public class Product {
    @Id
    private String id;
    
    @NotBlank(message = "Le nom du produit est obligatoire")
    private String name;
    
    @NotBlank(message = "La description est obligatoire")
    private String description;
    
    @Min(value = 0, message = "La quantité ne peut pas être négative")
    private int quantity;
    
    @Min(value = 0, message = "Le prix ne peut pas être négatif")
    private double price;
    
    private String sku;
    private String category;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

