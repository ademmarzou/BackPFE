package com.pfe.HRS.Service;


import com.pfe.HRS.Model.Banque;
import com.pfe.HRS.Repository.BanqueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BanqueS {

    private final BanqueRepo banqueRepo;

    @Autowired
    public BanqueS(BanqueRepo banqueRepo) {
        this.banqueRepo = banqueRepo;
    }

    public Banque enregistrerBanque(Banque banque)
    {

        return banqueRepo.save(banque);
    }

    public Banque getBanqueById(Long id) {
        return banqueRepo.findById(id).orElse(null);
    }

    public Banque updateBanque(Long id, Banque newBanqueDetails) {
        Banque existingBanque = banqueRepo.findById(id).orElse(null);
        if (existingBanque != null) {
            // Mettez à jour les attributs selon vos besoins
            existingBanque.setId(newBanqueDetails.getId());
            existingBanque.setDate(newBanqueDetails.getDate());
            existingBanque.setLibellepiece(newBanqueDetails.getLibellepiece());
            existingBanque.setNomCompte(newBanqueDetails.getNomCompte());
            existingBanque.setQuantite(newBanqueDetails.getQuantite());
            existingBanque.setDateecheance(newBanqueDetails.getDateecheance());

            existingBanque.setModedepaiement(newBanqueDetails.getModedepaiement());



            return banqueRepo.save(existingBanque);
        } else {
            return null;
        }
    }

    public void deleteBanque(Long id) {
        banqueRepo.deleteById(id);
    }

    public List<Banque> getAllBanques() {
        return banqueRepo.findAll();
    }

    public List<Banque> getBanqueByExerciceId(Long exerciceId) {
        return banqueRepo.findByExerciceId(exerciceId);
    }
}