package com.pfe.HRS.Repository;

import com.pfe.HRS.Model.PlanComptable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanComptableRepo extends JpaRepository<PlanComptable, Long> {
    // Méthodes spécifiques au repository CRUD déjà fournies par Spring Data JPA
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire
}