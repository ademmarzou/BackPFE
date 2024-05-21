package com.pfe.HRS.Repository;


import com.pfe.HRS.Model.Comptable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComptableRepo extends JpaRepository<Comptable, Long> {
    // Méthodes spécifiques au repository CRUD déjà fournies par Spring Data JPA
}