package com.pfe.HRS.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import com.pfe.HRS.Model.PlanComptable;
import com.pfe.HRS.Service.PlanComptableS;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@AllArgsConstructor
public class PlanComptableC {
    @Autowired

    private final PlanComptableS planComptableS;



    @PostMapping("/plan-comptable/enregistrerF")
    public PlanComptable enregistrerPlanComptable(@RequestBody PlanComptable planComptableM) {
        return planComptableS.enregistrerPlanComptable(planComptableM);
    }

    @GetMapping("/plan-comptable/{id}")
    public PlanComptable getPlanComptableById(@PathVariable Long id) {
        return planComptableS.getPlanComptableById(id);
    }
    
    @GetMapping("/plan-comptable/intitule/{id}")
    public String getIntituleById(@PathVariable Long id) {
        return planComptableS.getIntituleById(id);
    }

    @PutMapping("/plan-comptable/{id}")
    public PlanComptable updatePlanComptable(@PathVariable Long id, @RequestBody PlanComptable newPlanDetails) {
        return planComptableS.updatePlanComptable(id, newPlanDetails);
    }

    @DeleteMapping("/plan-comptable/{id}")
    public void deletePlanComptable(@PathVariable Long id) {
        planComptableS.deletePlanComptable(id);
    }

    @GetMapping("/plan-comptable/all")
    public List<PlanComptable> getAllPlanComptables() {
        return planComptableS.getAllPlanComptables();
    }
}