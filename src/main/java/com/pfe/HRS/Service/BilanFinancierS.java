package com.pfe.HRS.Service;


import com.pfe.HRS.Model.BilanFinancier;
import com.pfe.HRS.Repository.BilanFinancierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BilanFinancierS {

    private final BilanFinancierRepo bilanFinancierRepo;

    @Autowired
    public BilanFinancierS(BilanFinancierRepo bilanFinancierRepo) {
        this.bilanFinancierRepo = bilanFinancierRepo;
    }

    public BilanFinancier enregistrerBilanFinancier(BilanFinancier bilanFinancier) {
        return bilanFinancierRepo.save(bilanFinancier);
    }

    public BilanFinancier getBilanFinancierById(Long id) {
        return bilanFinancierRepo.findById(id).orElse(null);
    }

    public BilanFinancier updateBilanFinancier(Long id, BilanFinancier newBilanFinancierDetails) {
        BilanFinancier existingBilanFinancier = bilanFinancierRepo.findById(id).orElse(null);
        if (existingBilanFinancier != null) {
            existingBilanFinancier.setNmrBilan(newBilanFinancierDetails.getNmrBilan());
            existingBilanFinancier.setDate(newBilanFinancierDetails.getDate());
            existingBilanFinancier.setDebit(newBilanFinancierDetails.getDebit());
            existingBilanFinancier.setCredit(newBilanFinancierDetails.getCredit());
            return bilanFinancierRepo.save(existingBilanFinancier);
        } else {
            return null;
        }
    }

    public void deleteBilanFinancier(Long id) {
        bilanFinancierRepo.deleteById(id);
    }

    public List<BilanFinancier> getAllBilanFinanciers() {
        return bilanFinancierRepo.findAll();
    }
}

