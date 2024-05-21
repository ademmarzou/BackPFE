package com.pfe.HRS.Repository;

import com.pfe.HRS.Model.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BalanceRepo extends JpaRepository<Balance, Long> {
    List<Balance> findByExerciceId(Long exerciceId);
}

