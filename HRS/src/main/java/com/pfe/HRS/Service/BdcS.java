package com.pfe.HRS.Service;

import com.pfe.HRS.Model.Bdc;
import com.pfe.HRS.Repository.BdcRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BdcS {

    private final BdcRepo bdcRepo;

    @Autowired
    public BdcS(BdcRepo bdcRepo) {
        this.bdcRepo = bdcRepo;
    }

    // Enregistrer un nouveau Bdc
    public Bdc enregistrerBdc(Bdc bdc) {
        return bdcRepo.save(bdc);
    }

    // Récupérer un Bdc par son ID
    public Bdc getBdcById(Long id) {
        return bdcRepo.findById(id).orElse(null);
    }

    // Mettre à jour un Bdc
    public Bdc updateBdc(Long id, Bdc newBdcDetails) {
        Bdc existingBdc = bdcRepo.findById(id).orElse(null);
        if (existingBdc != null) {
            existingBdc.setId(newBdcDetails.getId());
            existingBdc.setDate(newBdcDetails.getDate());
            existingBdc.setDebit(newBdcDetails.getDebit());
            existingBdc.setLibellepiece(newBdcDetails.getLibellepiece());
            existingBdc.setNmrCompte(newBdcDetails.getNmrCompte());
            existingBdc.setPrix(newBdcDetails.getPrix());
            existingBdc.setQuantite(newBdcDetails.getQuantite());
            existingBdc.setNom(newBdcDetails.getNom());



            return bdcRepo.save(existingBdc);
        } else {
            return null;
        }
    }

    // Supprimer un Bdc par son ID
    public void deleteBdc(Long id) {
        bdcRepo.deleteById(id);
    }

    // Récupérer tous les Bdc
    public List<Bdc> getAllBdc() {
        return bdcRepo.findAll();
    }
    public List<Bdc> getBdcByExerciceId(Long exerciceId) {
        return bdcRepo.findByExerciceId(exerciceId);
    }
}