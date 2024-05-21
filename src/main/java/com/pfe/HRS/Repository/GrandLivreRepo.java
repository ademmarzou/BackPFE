package com.pfe.HRS.Repository;


import com.pfe.HRS.Model.GrandLivre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GrandLivreRepo extends JpaRepository<GrandLivre, Long> {
    List<GrandLivre> findByExerciceId(Long exerciceId);
    @Query("SELECT a.id FROM GrandLivre a WHERE a.idpiece = :idpiece ")
    List<Long> findAchatIdByIdpieceAndTypepiece(@Param("idpiece") Long idpiece);


}