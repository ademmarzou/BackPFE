package com.pfe.HRS.Repository;

import com.pfe.HRS.Model.Achat;
import com.pfe.HRS.Model.JournalComptable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JournalComptableRepo extends JpaRepository<JournalComptable, Long> {
    // Méthodes spécifiques au repository CRUD déjà fournies par Spring Data JPA
 }
