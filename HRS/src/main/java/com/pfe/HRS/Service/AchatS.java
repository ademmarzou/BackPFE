package com.pfe.HRS.Service;

import com.pfe.HRS.Model.Achat;
import com.pfe.HRS.Repository.AchatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AchatS {

    private final AchatRepo achatRepo;

    @Autowired
    public AchatS(AchatRepo achatRepo) {
        this.achatRepo = achatRepo;
    }

    // Enregistrer un nouvel achat
    public Achat enregistrerAchat(Achat achat) {
        return achatRepo.save(achat);
    }

    // Récupérer un achat par son ID
    public Achat getAchatById(Long id) {
        return achatRepo.findById(id).orElse(null);
    }

    // Mettre à jour un achat
    public Achat updateAchat(Long id, Achat newAchatDetails) {
        Achat existingAchat = achatRepo.findById(id).orElse(null);
        if (existingAchat != null) {
            existingAchat.setId(newAchatDetails.getId());
            existingAchat.setDebit(newAchatDetails.getDebit());
            existingAchat.setLibellepiece(newAchatDetails.getLibellepiece());
            existingAchat.setNmrCompte(newAchatDetails.getNmrCompte());
            existingAchat.setIdpiece(newAchatDetails.getIdpiece());
            existingAchat.setTypepiece(newAchatDetails.getTypepiece());
            existingAchat.setNom(newAchatDetails.getNom());

            existingAchat.setDate(newAchatDetails.getDate());
            existingAchat.setQuantite(newAchatDetails.getQuantite());




            return achatRepo.save(existingAchat);
        } else {
            return null;
        }
    }

    // Supprimer un achat par son ID
    public void deleteAchat(Long id) {
        achatRepo.deleteById(id);
    }

    // Récupérer tous les achats
    public List<Achat> getAllAchats() {
        return achatRepo.findAll();
    }
    public List<Achat> getAchatByExerciceId(Long exerciceId) {
        return achatRepo.findByExerciceId(exerciceId);
    }

}