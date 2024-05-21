package com.pfe.HRS.Service;


import com.pfe.HRS.Model.Fournisseur;
import com.pfe.HRS.Repository.FournisseurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FournisseurS {

    private final FournisseurRepo fournisseurRepo;

    @Autowired
    public FournisseurS(FournisseurRepo fournisseurRepo) {
        this.fournisseurRepo = fournisseurRepo;
    }

    // Créer un nouveau fournisseur
    public Fournisseur enregistrerFournisseur(Fournisseur fournisseur) {
        return fournisseurRepo.save(fournisseur);
    }

    // Récupérer un fournisseur par son ID
    public Fournisseur getFournisseurById(Long id) {
        return fournisseurRepo.findById(id).orElse(null);
    }

    // Mettre à jour un fournisseur
    public Fournisseur updateFournisseur(Long fournisseurId, Fournisseur newFournisseurDetails) {
        Fournisseur existingFournisseur = fournisseurRepo.findById(fournisseurId).orElse(null);
        if (existingFournisseur != null) {
            // Mettez à jour les attributs selon vos besoins
            existingFournisseur.setIdFournisseur(newFournisseurDetails.getIdFournisseur());
            return fournisseurRepo.save(existingFournisseur);
        } else {
            return null;
        }
    }

    // Supprimer un fournisseur par son ID
    public void deleteFournisseur(Long id) {
        fournisseurRepo.deleteById(id);
    }

    // Récupérer tous les fournisseurs
    public List<Fournisseur> getAllFournisseurs() {
        return fournisseurRepo.findAll();
    }
}