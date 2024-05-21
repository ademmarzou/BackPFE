package com.pfe.HRS.Controller;

import com.pfe.HRS.Model.Banque;
import com.pfe.HRS.Service.BanqueS;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class BanqueC {
    @Autowired

    private final BanqueS banqueS;


    @PostMapping("/Banque/enregistrer/{exerciceId}")
    public List<Banque> enregistrerBanque(@RequestBody List<Banque> banques , @PathVariable Long exerciceId) {
        List<Banque> result = new ArrayList<>();
        for (Banque banque : banques) {
            banque.setExerciceId(exerciceId); // assuming Achat class has a method setExerciceId
            result.add(banqueS.enregistrerBanque(banque));
        }
        return result;
    }

    @GetMapping("/Banque/{id}")
    public Banque getBanqueById(@PathVariable Long id) {
        return banqueS.getBanqueById(id);
    }

    @PutMapping("/Banque/{id}")
    public Banque updateBanque(@PathVariable Long id, @RequestBody Banque newBanqueDetails) {
        return banqueS.updateBanque(id, newBanqueDetails);
    }

    @DeleteMapping("/Banque/{id}")
    public void deleteBanque(@PathVariable Long id) {
        banqueS.deleteBanque(id);
    }

    @GetMapping("/Banque/all")
    public List<Banque> getAllBanques() {
        return banqueS.getAllBanques();
    }

    @GetMapping("/Banque/exercice/{exerciceId}")
    public List<Banque> getBanqueByExerciceId(@PathVariable Long exerciceId) {
        return banqueS.getBanqueByExerciceId(exerciceId);
    }
}
