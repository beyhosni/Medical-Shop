# Medical-Shop
 Une application de vente de matériel médical


1. Architecture du système
API Gateway : Pour centraliser les appels aux microservices, gérer l’authentification, et équilibrer la charge.
Service d'authentification : Pour la gestion des utilisateurs (inscription, connexion) et les autorisations.
Service de produits : Pour gérer le catalogue de matériel médical (CRUD des produits, catégories, recherche).
Service de commande : Pour gérer les commandes des utilisateurs, le suivi et le statut des commandes.
Service de notification : Envoie des notifications (par exemple par e-mail ou SMS) pour informer les utilisateurs sur l’état de leurs commandes.
Service d'inventaire : Pour gérer les stocks et synchroniser les mises à jour avec le service de commande.
Kafka : Utilisé comme broker de messages pour la communication entre les services (notifications, mises à jour d’inventaire, etc.).
MongoDB : Base de données utilisée par chaque service pour stocker ses données spécifiques.



medical-equipment-sales-app/
│
├── api-gateway/
│   ├── src/
│   └── Dockerfile
│
├── auth-service/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/auth/
│   │   │   │   ├── controller/
│   │   │   │   ├── service/
│   │   │   │   └── model/
│   │   └── resources/
│   └── Dockerfile
│
├── product-service/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/product/
│   │   │   │   ├── controller/
│   │   │   │   ├── service/
│   │   │   │   └── model/
│   │   └── resources/
│   └── Dockerfile
│
├── order-service/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/order/
│   │   │   │   ├── controller/
│   │   │   │   ├── service/
│   │   │   │   └── model/
│   │   └── resources/
│   └── Dockerfile
│
├── inventory-service/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/inventory/
│   │   │   │   ├── controller/
│   │   │   │   ├── service/
│   │   │   │   └── model/
│   │   └── resources/
│   └── Dockerfile
│
├── notification-service/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/notification/
│   │   │   │   ├── controller/
│   │   │   │   ├── service/
│   │   │   │   └── model/
│   │   └── resources/
│   └── Dockerfile
│
├── kafka-config/
│   ├── src/
│   └── Dockerfile
│
├── frontend/
│   ├── public/
│   ├── src/
│   │   ├── assets/
│   │   ├── components/
│   │   ├── pages/
│   │   └── services/
│   └── Dockerfile
│
└── docker-compose.yml
