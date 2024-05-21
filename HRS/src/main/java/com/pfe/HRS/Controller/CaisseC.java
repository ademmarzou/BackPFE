package com.pfe.HRS.Controller;

import com.pfe.HRS.Model.Caisse;
import com.pfe.HRS.Service.CaisseS;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class CaisseC {
    @Autowired

    private final CaisseS caisseS;


    @PostMapping("/Caisse/enregistrer/{exerciceId}")
    public List<Caisse> enregistrerCaisse(@RequestBody List<Caisse> caisses  , @PathVariable Long exerciceId) {
        List<Caisse> result = new ArrayList<>();
        for (Caisse caisse : caisses) {
            caisse.setExerciceId(exerciceId); // assuming Achat class has a method setExerciceId
            result.add(caisseS.enregistrerCaisse(caisse));
        }
        return result;
    }

    @GetMapping("/Caisse/{id}")
    public Caisse getCaisseById(@PathVariable Long id) {
        return caisseS.getCaisseById(id);
    }

    @PutMapping("/Caisse/{id}")
    public Caisse updateCaisse(@PathVariable Long id, @RequestBody Caisse newCaisseDetails) {
        return caisseS.updateCaisse(id, newCaisseDetails);
    }

    @DeleteMapping("/Caisse/{id}")
    public void deleteCaisse(@PathVariable Long id) {
        caisseS.deleteCaisse(id);
    }

    @GetMapping("/Caisse/all")
    public List<Caisse> getAllCaisses() {
        return caisseS.getAllCaisses();
    }

    @GetMapping("/Caisse/exercice/{exerciceId}")
    public List<Caisse> getCaisseByExerciceId(@PathVariable Long exerciceId) {
        return caisseS.getCaisseByExerciceId(exerciceId);
    }
}