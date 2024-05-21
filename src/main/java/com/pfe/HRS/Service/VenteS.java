package com.pfe.HRS.Service;

import com.pfe.HRS.Model.Vente;
import com.pfe.HRS.Repository.VenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenteS {

    private final VenteRepo venteRepo;

    @Autowired
    public VenteS(VenteRepo venteRepo) {
        this.venteRepo = venteRepo;
    }

    // Enregistrer une nouvelle vente
    public Vente enregistrerVente(Vente vente) {
        return venteRepo.save(vente);
    }

    // Récupérer une vente par son ID
    public Vente getVenteById(Long id) {
        return venteRepo.findById(id).orElse(null);
    }

    // Mettre à jour une vente
    public Vente updateVente(Long id, Vente newVenteDetails) {
        Vente existingVente = venteRepo.findById(id).orElse(null);
        if (existingVente != null) {
            existingVente.setId(newVenteDetails.getId());
            existingVente.setDebit(newVenteDetails.getDebit());
            existingVente.setLibellepiece(newVenteDetails.getLibellepiece());
            existingVente.setNmrCompte(newVenteDetails.getNmrCompte());
            existingVente.setDate(newVenteDetails.getDate());
            existingVente.setQuantite(newVenteDetails.getQuantite());


            return venteRepo.save(existingVente);
        } else {
            return null;
        }
    }

    // Supprimer une vente par son ID
    public void deleteVente(Long id) {
        venteRepo.deleteById(id);
    }

    // Récupérer toutes les ventes
    public List<Vente> getAllVentes() {
        return venteRepo.findAll();
    }

    public List<Vente> getVenteByExerciceId(Long exerciceId) {
        return venteRepo.findByExerciceId(exerciceId);
    }
}