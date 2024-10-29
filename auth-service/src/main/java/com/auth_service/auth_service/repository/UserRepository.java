package com.auth_service.auth_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.auth_service.auth_service.model.User;


public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    List<User> findByEnabled(boolean enabled);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    List<User> findByUsernameLike(String username);
    void deleteByUsername(String username);
    
    // Pour une recherche combinée
    Optional<User> findByUsernameAndEmail(String username, String email);
    
    // Pour une recherche avec tri
    @org.springframework.data.mongodb.repository.Query(value = "{}", sort = "{ username : 1 }")
    List<User> findAllByOrderByUsernameAsc();
}
