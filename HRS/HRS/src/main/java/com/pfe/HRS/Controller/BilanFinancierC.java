package com.pfe.HRS.Controller;

import com.pfe.HRS.Model.BilanFinancier;
import com.pfe.HRS.Service.BilanFinancierS;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class BilanFinancierC {
    @Autowired
    private final BilanFinancierS bilanFinancierS;



    @PostMapping("/BilanFinancier/enregistrer")
    public BilanFinancier enregistrerBilanFinancier(@RequestBody BilanFinancier bilanFinancierM) {
        return bilanFinancierS.enregistrerBilanFinancier(bilanFinancierM);
    }

    @GetMapping("/BilanFinancier/{id}")
    public BilanFinancier getBilanFinancierById(@PathVariable Long id) {
        return bilanFinancierS.getBilanFinancierById(id);
    }

    @PutMapping("/BilanFinancier/{id}")
    public BilanFinancier updateBilanFinancier(@PathVariable Long id, @RequestBody BilanFinancier newBilanFinancierDetails) {
        return bilanFinancierS.updateBilanFinancier(id, newBilanFinancierDetails);
    }

    @DeleteMapping("/BilanFinancier/{id}")
    public void deleteBilanFinancier(@PathVariable Long id) {
        bilanFinancierS.deleteBilanFinancier(id);
    }

    @GetMapping("/BilanFinancier/all")
    public List<BilanFinancier> getAllBilanFinanciers() {
        return bilanFinancierS.getAllBilanFinanciers();
    }
}
