package com.pfe.HRS.Repository;

import com.pfe.HRS.Model.BilanFinancier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BilanFinancierRepo extends JpaRepository<BilanFinancier, Long> {
    // Méthodes spécifiques au repository CRUD déjà fournies par Spring Data JPA
}
