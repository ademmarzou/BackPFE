package com.pfe.HRS.Repository;

import com.pfe.HRS.Model.Bdc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BdcRepo extends JpaRepository<Bdc, Long> {
    // CRUD methods are already provided by JpaRepository
    List<Bdc> findByExerciceId(Long exerciceId);}