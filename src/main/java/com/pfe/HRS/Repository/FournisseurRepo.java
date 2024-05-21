package com.pfe.HRS.Repository;

import com.pfe.HRS.Model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FournisseurRepo extends JpaRepository<Fournisseur, Long> {
    // Méthodes spécifiques au repository CRUD déjà fournies par Spring Data JPA
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire
}

