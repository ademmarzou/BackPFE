package com.pfe.HRS.Controller;

import com.pfe.HRS.Model.Devis;
import com.pfe.HRS.Service.DevisS;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class DevisC {
    @Autowired
    private final DevisS devisS;

    @PostMapping("/Devis/enregistrer/{exerciceId}")
    public List<Devis> enregistrerDevis(@RequestBody List<Devis> devis , @PathVariable Long exerciceId) {
        List<Devis> result = new ArrayList<>();
        for (Devis devi : devis) {
            devi.setExerciceId(exerciceId); // assuming Achat class has a method setExerciceId
            result.add(devisS.enregistrerDevis(devi));
        }
        return result;
    }

    @GetMapping("/Devis/{id}")
    public Devis getDevisById(@PathVariable Long id) {
        return devisS.getDevisById(id);
    }

    @PutMapping("/Devis/{id}")
    public Devis updateDevis(@PathVariable Long id, @RequestBody Devis newDevisDetails) {
        return devisS.updateDevis(id, newDevisDetails);
    }

    @DeleteMapping("/Devis/{id}")
    public void deleteDevis(@PathVariable Long id) {
        devisS.deleteDevis(id);
    }

    @GetMapping("/Devis/all")
    public List<Devis> getAllDevis() {
        return devisS.getAllDevis();
    }
    @GetMapping("/Devis/exercice/{exerciceId}")
    public List<Devis> getDevisByExerciceId(@PathVariable Long exerciceId) {
        return devisS.getDevisByExerciceId(exerciceId);
    }
}