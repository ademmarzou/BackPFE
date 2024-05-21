package com.pfe.HRS.Repository;

import com.pfe.HRS.Model.Caisse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaisseRepo extends JpaRepository<Caisse, Long> {
    List<Caisse> findByExerciceId(Long exerciceId);}