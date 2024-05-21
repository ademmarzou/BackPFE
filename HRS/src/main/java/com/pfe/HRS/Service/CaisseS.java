package com.pfe.HRS.Service;

import com.pfe.HRS.Model.Caisse;
import com.pfe.HRS.Repository.CaisseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaisseS {

    private final CaisseRepo caisseRepo;

    @Autowired
    public CaisseS(CaisseRepo caisseRepo) {
        this.caisseRepo = caisseRepo;
    }

    public Caisse enregistrerCaisse(Caisse caisse)
    {
        return caisseRepo.save(caisse);
    }

    public Caisse getCaisseById(Long id) {
        return caisseRepo.findById(id).orElse(null);
    }

    public Caisse updateCaisse(Long id, Caisse newCaisseDetails) {
        Caisse existingCaisse = caisseRepo.findById(id).orElse(null);
        if (existingCaisse != null) {
            // Update the attributes as per your needs
            existingCaisse.setId(newCaisseDetails.getId());
            existingCaisse.setDate(newCaisseDetails.getDate());
            existingCaisse.setLibellepiece(newCaisseDetails.getLibellepiece());
            existingCaisse.setNomCompte(newCaisseDetails.getNomCompte());
            existingCaisse.setQuantite(newCaisseDetails.getQuantite());
            existingCaisse.setModedepaiement(newCaisseDetails.getModedepaiement());
            existingCaisse.setDateecheance(newCaisseDetails.getDateecheance());


            return caisseRepo.save(existingCaisse);
        } else {
            return null;
        }
    }

    public void deleteCaisse(Long id) {
        caisseRepo.deleteById(id);
    }

    public List<Caisse> getAllCaisses() {
        return caisseRepo.findAll();
    }
    public List<Caisse> getCaisseByExerciceId(Long exerciceId) {
        return caisseRepo.findByExerciceId(exerciceId);
    }
}