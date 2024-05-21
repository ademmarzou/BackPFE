package com.pfe.HRS.Repository;

import com.pfe.HRS.Model.Banque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BanqueRepo extends JpaRepository<Banque, Long> {
    List<Banque> findByExerciceId(Long exerciceId);
}