package com.pfe.HRS.Repository;

import com.pfe.HRS.Model.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VenteRepo extends JpaRepository<Vente, Long> {
    List<Vente> findByExerciceId(Long exerciceId);
}