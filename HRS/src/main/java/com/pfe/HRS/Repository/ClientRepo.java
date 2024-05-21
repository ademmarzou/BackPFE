package com.pfe.HRS.Repository;

import com.pfe.HRS.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {
    // Méthodes spécifiques au repository CRUD déjà fournies par Spring Data JPA
}