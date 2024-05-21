package com.pfe.HRS.Repository;

import com.pfe.HRS.Model.Devis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DevisRepo extends JpaRepository<Devis, Long> {
    // Méthodes spécifiques au repository CRUD déjà fournies par JpaRepository
    List<Devis> findByExerciceId(Long exerciceId);
}