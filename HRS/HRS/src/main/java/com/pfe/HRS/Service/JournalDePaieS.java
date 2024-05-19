package com.pfe.HRS.Service;


import com.pfe.HRS.Model.JournalDePaie;
import com.pfe.HRS.Repository.JournalDePaieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalDePaieS {

    private final JournalDePaieRepo journalDePaieRepo;

    @Autowired
    public JournalDePaieS(JournalDePaieRepo journalDePaieRepo) {
        this.journalDePaieRepo = journalDePaieRepo;
    }

    // Créer un nouveau journal de paie
    public JournalDePaie enregistrerJournalDePaie(JournalDePaie journalDePaie) {
        return journalDePaieRepo.save(journalDePaie);
    }

    // Récupérer un journal de paie par son ID
    public JournalDePaie getJournalDePaieById(Long id) {
        return journalDePaieRepo.findById(id).orElse(null);
    }

    // Mettre à jour un journal de paie
    public JournalDePaie updateJournalDePaie(Long journalDePaieId, JournalDePaie newJournalDePaieDetails) {
        JournalDePaie existingJournalDePaie = journalDePaieRepo.findById(journalDePaieId).orElse(null);
        if (existingJournalDePaie != null) {
            // Mettez à jour les attributs selon vos besoins
            existingJournalDePaie.setIdEmp(newJournalDePaieDetails.getIdEmp());
            existingJournalDePaie.setTotal(newJournalDePaieDetails.getIdEmp());
            existingJournalDePaie.setIdJDP(newJournalDePaieDetails.getIdJDP());
            return journalDePaieRepo.save(existingJournalDePaie);
        } else {
            return null;
        }
    }

    // Supprimer un journal de paie par son ID
    public void deleteJournalDePaie(Long id) {
        journalDePaieRepo.deleteById(id);
    }

    // Récupérer tous les journaux de paie
    public List<JournalDePaie> getAllJournalDePaies() {
        return journalDePaieRepo.findAll();
    }
}