package com.pfe.HRS.Service;


import com.pfe.HRS.Model.PlanComptable;
import com.pfe.HRS.Repository.PlanComptableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanComptableS {

    private final PlanComptableRepo planComptableRepo;

    @Autowired
    public PlanComptableS(PlanComptableRepo planComptableRepo) {
        this.planComptableRepo = planComptableRepo;
    }

    // Créer un nouveau plan comptable
    public PlanComptable enregistrerPlanComptable(PlanComptable planComptable) {
        return planComptableRepo.save(planComptable);
    }

    // Récupérer un plan comptable par son ID
    public PlanComptable getPlanComptableById(Long id) {
        return planComptableRepo.findById(id).orElse(null);
    }

    // Mettre à jour un plan comptable
    public PlanComptable updatePlanComptable(Long planComptableId, PlanComptable newPlanComptableDetails) {
        PlanComptable existingPlanComptable = planComptableRepo.findById(planComptableId).orElse(null);
        if (existingPlanComptable != null) {
            // Mettez à jour les attributs selon vos besoins
            existingPlanComptable.setIntitule(newPlanComptableDetails.getIntitule());
            existingPlanComptable.setNcompte(newPlanComptableDetails.getNcompte());
            // Ajoutez les autres attributs à mettre à jour ici
            return planComptableRepo.save(existingPlanComptable);
        } else {
            return null;
        }
    }
    public String getIntituleById(Long id) {
        PlanComptable planComptable = getPlanComptableById(id);
        if (planComptable != null) {
            return planComptable.getIntitule();
        } else {
            return null; // ou une chaîne vide, ou une valeur par défaut selon vos besoins
        }
    }
    // Supprimer un plan comptable par son ID
    public void deletePlanComptable(Long id) {
        planComptableRepo.deleteById(id);
    }

    // Récupérer tous les plans comptables
    public List<PlanComptable> getAllPlanComptables() {
        return planComptableRepo.findAll();
    }
}
