package com.pfe.HRS.Repository;

import com.pfe.HRS.Model.Exercice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExerciceRepo extends JpaRepository<Exercice, Long> {
    @Query("SELECT e FROM Exercice e WHERE YEAR(e.date) = :year")
    List<Exercice> findByYear(@Param("year") int year);

}