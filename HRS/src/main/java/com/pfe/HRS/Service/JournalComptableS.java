package com.pfe.HRS.Service;


import com.pfe.HRS.Model.JournalComptable;
import com.pfe.HRS.Repository.JournalComptableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalComptableS {

    private final JournalComptableRepo journalComptableRepo;

    @Autowired
    public JournalComptableS(JournalComptableRepo journalComptableRepo) {
        this.journalComptableRepo = journalComptableRepo;
    }

    // Créer un nouveau journal comptable
    public JournalComptable enregistrerJournalComptable(JournalComptable journalComptable) {
        return journalComptableRepo.save(journalComptable);
    }

    // Récupérer un journal comptable par son ID
    public JournalComptable getJournalComptableById(Long id) {
        return journalComptableRepo.findById(id).orElse(null);
    }

    // Mettre à jour un journal comptable
    // Mettre à jour un journal comptable
    public JournalComptable updateJournalComptable(Long id, JournalComptable newJournalComptableDetails) {
        JournalComptable existingJournalComptable = journalComptableRepo.findById(id).orElse(null);
        if (existingJournalComptable != null) {
            existingJournalComptable.setNmrCompte(newJournalComptableDetails.getNmrCompte());
            existingJournalComptable.setCodejournal(newJournalComptableDetails.getCodejournal());
            existingJournalComptable.setLibellepiece(newJournalComptableDetails.getLibellepiece());
            existingJournalComptable.setDebit(newJournalComptableDetails.getDebit());
            existingJournalComptable.setIdpiece(newJournalComptableDetails.getIdpiece());
            existingJournalComptable.setTypepiece(newJournalComptableDetails.getTypepiece());
            existingJournalComptable.setLibelledebit(newJournalComptableDetails.getLibelledebit());
            existingJournalComptable.setComptedebit(newJournalComptableDetails.getComptedebit());
            existingJournalComptable.setCredit(newJournalComptableDetails.getCredit());
            existingJournalComptable.setLibellecredit(newJournalComptableDetails.getLibellecredit());
            existingJournalComptable.setComptecredit(newJournalComptableDetails.getComptecredit());
            existingJournalComptable.setDate(newJournalComptableDetails.getDate());
            existingJournalComptable.setSolde(newJournalComptableDetails.getSolde());
            existingJournalComptable.setNom(newJournalComptableDetails.getNom());
            existingJournalComptable.setModedepaiement(newJournalComptableDetails.getModedepaiement());
            existingJournalComptable.setDateecheance(newJournalComptableDetails.getDateecheance());
            existingJournalComptable.setQuantite(newJournalComptableDetails.getQuantite());



            return journalComptableRepo.save(existingJournalComptable);
        } else {
            return null;
        }
    }


    // Supprimer un journal comptable par son ID
    public void deleteJournalComptable(Long id) {
        journalComptableRepo.deleteById(id);
    }

    // Récupérer tous les journaux comptables
    public List<JournalComptable> getAllJournalComptables() {
        return journalComptableRepo.findAll();
    }

}
