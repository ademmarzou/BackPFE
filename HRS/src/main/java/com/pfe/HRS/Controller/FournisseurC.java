package com.pfe.HRS.Controller;

import com.pfe.HRS.Model.Fournisseur;
import com.pfe.HRS.Service.FournisseurS;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class FournisseurC {
    @Autowired
    private final FournisseurS fournisseurS;

    @PostMapping("/fournisseurs/enregistrerF")
    public Fournisseur enregistrerFournisseur(@RequestBody Fournisseur fournisseurM) {
        return fournisseurS.enregistrerFournisseur(fournisseurM);
    }

    @GetMapping("/fournisseurs/{id}")
    public Fournisseur getFournisseurById(@PathVariable Long id) {
        return fournisseurS.getFournisseurById(id);
    }

    @PutMapping("/fournisseurs/{id}")
    public Fournisseur updateFournisseur(@PathVariable Long id, @RequestBody Fournisseur newFournisseurDetails) {
        return fournisseurS.updateFournisseur(id, newFournisseurDetails);
    }

    @DeleteMapping("/fournisseurs/{id}")
    public void deleteFournisseur(@PathVariable Long id) {
        fournisseurS.deleteFournisseur(id);
    }

    @GetMapping("/fournisseurs/all")
    public List<Fournisseur> getAllFournisseurs() {
        return fournisseurS.getAllFournisseurs();
    }
}
