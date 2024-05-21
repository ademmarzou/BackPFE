package com.pfe.HRS.Controller;


import com.pfe.HRS.Model.Comptable;
import com.pfe.HRS.Service.ComptableS;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ComptableC {
    @Autowired
    private final ComptableS comptableS;

    @PostMapping("/Comptable/enregistrer")
    public Comptable enregistrerComptable(@RequestBody Comptable comptableM) {
        return comptableS.enregistrerComptable(comptableM);
    }

    @GetMapping("/Comptable/{id}")
    public Comptable getComptableById(@PathVariable Long id) {
        return comptableS.getComptableById(id);
    }

    @PutMapping("/Comptable/{id}")
    public Comptable updateComptable(@PathVariable Long id, @RequestBody Comptable newComptableDetails) {
        return comptableS.updateComptable(id, newComptableDetails);
    }

    @DeleteMapping("/Comptable/{id}")
    public void deleteComptable(@PathVariable Long id) {
        comptableS.deleteComptable(id);
    }

    @GetMapping("/Comptable/all")
    public List<Comptable> getAllComptables() {
        return comptableS.getAllComptables();
    }
}