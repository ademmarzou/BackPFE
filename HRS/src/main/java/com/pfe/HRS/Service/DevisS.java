package com.pfe.HRS.Service;

import com.pfe.HRS.Model.Devis;
import com.pfe.HRS.Repository.DevisRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DevisS {

    private final DevisRepo devisRepo;

    @Autowired
    public DevisS(DevisRepo devisRepo) {
        this.devisRepo = devisRepo;
    }

    // Enregistrer un nouveau devis
    public Devis enregistrerDevis(Devis devis) {
        return devisRepo.save(devis);
    }

    // Récupérer un devis par son ID
    public Devis getDevisById(Long id) {
        return devisRepo.findById(id).orElse(null);
    }

    // Mettre à jour un devis
    public Devis updateDevis(Long id, Devis newDevisDetails) {
        Devis existingDevis = devisRepo.findById(id).orElse(null);
        if (existingDevis != null) {
            existingDevis.setId(newDevisDetails.getId());
            existingDevis.setDate(newDevisDetails.getDate());
            existingDevis.setDebit(newDevisDetails.getDebit());
            existingDevis.setLibellepiece(newDevisDetails.getLibellepiece());
            existingDevis.setNmrCompte(newDevisDetails.getNmrCompte());
            existingDevis.setNom(newDevisDetails.getNom());
            existingDevis.setPrix(newDevisDetails.getPrix());
            existingDevis.setQuantite(newDevisDetails.getQuantite());




            return devisRepo.save(existingDevis);
        } else {
            return null;
        }
    }

    // Supprimer un devis par son ID
    public void deleteDevis(Long id) {
        devisRepo.deleteById(id);
    }

    // Récupérer tous les devis
    public List<Devis> getAllDevis() {
        return devisRepo.findAll();
    }
    public List<Devis> getDevisByExerciceId(Long exerciceId) {
        return devisRepo.findByExerciceId(exerciceId);
    }
}