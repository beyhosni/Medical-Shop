package main.java.com.product_service.product_service.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "products")
public class Product {

    @Id
    private String id;
    private String name;
    private String description;
    private double price;
    private int stock;
    
    private String referenceNumber;      // Numéro de référence unique
    private String manufacturer;         // Fabricant
    private Date expirationDate;         // Date d'expiration
    private String batchNumber;          // Numéro de lot
    private String category;             // Catégorie (ex: médicament, matériel médical, etc.)
    private String dosageForm;           // Forme galénique (comprimé, solution, etc.)
    private String activeIngredient;     // Principe actif
    private boolean prescriptionRequired; // Nécessite une ordonnance
    private String storageConditions;    // Conditions de stockage
    private String regulatoryStatus;     // Statut réglementaire
}

