package com.pfe.HRS.Controller;

import com.pfe.HRS.Model.Vente;
import com.pfe.HRS.Service.VenteS;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class VenteC {
    @Autowired
    private final VenteS venteS;

    @PostMapping("/Vente/enregistrer/{exerciceId}")
    public List<Vente> enregistrerVente(@RequestBody List<Vente> ventes , @PathVariable Long exerciceId) {
        List<Vente> result = new ArrayList<>();
        for (Vente vente : ventes) {
            vente.setExerciceId(exerciceId); // assuming Achat class has a method setExerciceId

            result.add(venteS.enregistrerVente(vente));
        }
        return result;
    }

    @GetMapping("/Vente/{id}")
    public Vente getVenteById(@PathVariable Long id) {
        return venteS.getVenteById(id);
    }

    @PutMapping("/Vente/{id}")
    public Vente updateVente(@PathVariable Long id, @RequestBody Vente newVenteDetails) {
        return venteS.updateVente(id, newVenteDetails);
    }

    @DeleteMapping("/Vente/{id}")
    public void deleteVente(@PathVariable Long id) {
        venteS.deleteVente(id);
    }

    @GetMapping("/Vente/all")
    public List<Vente> getAllVentes() {
        return venteS.getAllVentes();
    }

    @GetMapping("/Vente/exercice/{exerciceId}")
    public List<Vente> getVenteByExerciceId(@PathVariable Long exerciceId) {
        return venteS.getVenteByExerciceId(exerciceId);
    }
}