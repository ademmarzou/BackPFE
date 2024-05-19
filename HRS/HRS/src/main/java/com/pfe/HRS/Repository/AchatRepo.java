package com.pfe.HRS.Repository;

import com.pfe.HRS.Model.Achat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AchatRepo extends JpaRepository<Achat, Long> {
    List<Achat> findByExerciceId(Long exerciceId);

}