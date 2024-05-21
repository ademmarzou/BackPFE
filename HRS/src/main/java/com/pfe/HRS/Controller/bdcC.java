package com.pfe.HRS.Controller;

import com.pfe.HRS.Model.Bdc;
import com.pfe.HRS.Service.BdcS;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class bdcC {
    @Autowired
    private final BdcS bdcS;

    @PostMapping("/Bdc/enregistrer/{exerciceId}")
    public List<Bdc> enregistrerBdc(@RequestBody List<Bdc> bdcs , @PathVariable Long exerciceId) {
        List<Bdc> result = new ArrayList<>();
        for (Bdc bdc : bdcs) {
            bdc.setExerciceId(exerciceId); // assuming Achat class has a method setExerciceId
            result.add(bdcS.enregistrerBdc(bdc));
        }
        return result;
    }

    @GetMapping("/Bdc/{id}")
    public Bdc getBdcById(@PathVariable Long id) {
        return bdcS.getBdcById(id);
    }

    @PutMapping("/Bdc/{id}")
    public Bdc updateBdc(@PathVariable Long id, @RequestBody Bdc newBdcDetails) {
        return bdcS.updateBdc(id, newBdcDetails);
    }

    @DeleteMapping("/Bdc/{id}")
    public void deleteBdc(@PathVariable Long id) {
        bdcS.deleteBdc(id);
    }

    @GetMapping("/Bdc/all")
    public List<Bdc> getAllBdc() {
        return bdcS.getAllBdc();
    }
    @GetMapping("/Bdc/exercice/{exerciceId}")
    public List<Bdc> getBdcByExerciceId(@PathVariable Long exerciceId) {
        return bdcS.getBdcByExerciceId(exerciceId);
    }
}