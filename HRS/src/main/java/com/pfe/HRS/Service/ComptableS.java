package com.pfe.HRS.Service;


import com.pfe.HRS.Model.Comptable;
import com.pfe.HRS.Repository.ComptableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComptableS {

    private final ComptableRepo comptableRepo;

    @Autowired
    public ComptableS(ComptableRepo comptableRepo) {
        this.comptableRepo = comptableRepo;
    }

    public Comptable enregistrerComptable(Comptable comptable) {
        return comptableRepo.save(comptable);
    }

    public Comptable getComptableById(Long id) {
        return comptableRepo.findById(id).orElse(null);
    }

    public Comptable updateComptable(Long id, Comptable newComptableDetails) {
        Comptable existingComptable = comptableRepo.findById(id).orElse(null);
        if (existingComptable != null) {
            // Mettez à jour les attributs selon vos besoins
            existingComptable.setIdComptable(newComptableDetails.getIdComptable());
            // ...

            return comptableRepo.save(existingComptable);
        } else {
            return null;
        }
    }

    public void deleteComptable(Long id) {
        comptableRepo.deleteById(id);
    }

    public List<Comptable> getAllComptables() {
        return comptableRepo.findAll();
    }
}