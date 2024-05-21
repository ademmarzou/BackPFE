package com.pfe.HRS.Repository;

import com.pfe.HRS.Model.AgentRH;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRHRepo extends JpaRepository<AgentRH, Long> {
    // Méthodes spécifiques au repository crud deja fait par le jpa
    //findByNomFournisseur
    //findByDateAchatBetween
    //ETC ..
}