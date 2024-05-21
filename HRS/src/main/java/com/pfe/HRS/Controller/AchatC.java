package com.pfe.HRS.Controller;

import com.pfe.HRS.Model.Achat;
import com.pfe.HRS.Service.AchatS;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class AchatC {
    @Autowired
    private final AchatS achatS;

    @PostMapping("/Achat/enregistrer/{exerciceId}")
    public List<Achat> enregistrerAchat(@RequestBody List<Achat> achats , @PathVariable Long exerciceId) {
        List<Achat> result = new ArrayList<>();
        for (Achat achat : achats) {
            achat.setExerciceId(exerciceId); // assuming Achat class has a method setExerciceId
            result.add(achatS.enregistrerAchat(achat));
        }
        return result;
    }

    @GetMapping("/Achat/{id}")
    public Achat getAchatById(@PathVariable Long id) {
        return achatS.getAchatById(id);
    }

    @PutMapping("/Achat/{id}")
    public Achat updateAchat(@PathVariable Long id, @RequestBody Achat newAchatDetails) {
        return achatS.updateAchat(id, newAchatDetails);
    }

    @DeleteMapping("/Achat/{id}")
    public void deleteAchat(@PathVariable Long id) {
        achatS.deleteAchat(id);
    }

    @GetMapping("/Achat/all")
    public List<Achat> getAllAchats() {
        return achatS.getAllAchats();
    }


    @GetMapping("/Achat/exercice/{exerciceId}")
    public List<Achat> getAchatByExerciceId(@PathVariable Long exerciceId) {
        return achatS.getAchatByExerciceId(exerciceId);
    }

}