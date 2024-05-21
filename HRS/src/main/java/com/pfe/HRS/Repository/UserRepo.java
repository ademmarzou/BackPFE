package com.pfe.HRS.Repository;

import com.pfe.HRS.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Optional <User> findByEmail(String email);

    boolean existsByEmail(String email);
    // Méthodes spécifiques au repository CRUD déjà fournies par Spring Data JPA
}