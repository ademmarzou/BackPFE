package com.pfe.HRS.Service;

import com.pfe.HRS.Model.Balance;
import com.pfe.HRS.Repository.BalanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalanceS {

    private final BalanceRepo balanceRepo;

    @Autowired
    public BalanceS(BalanceRepo balanceRepo) {
        this.balanceRepo = balanceRepo;
    }

    public Balance enregistrerBalance(Balance balance) {
        return balanceRepo.save(balance);
    }

    public Balance getBalanceById(Long id) {
        return balanceRepo.findById(id).orElse(null);
    }

    public Balance updateBalance(Long id, Balance newBalanceDetails) {
        Balance existingBalance = balanceRepo.findById(id).orElse(null);
        if (existingBalance != null) {
            existingBalance.setId(newBalanceDetails.getId());
            existingBalance.setDebit(newBalanceDetails.getDebit());
            existingBalance.setCredit(newBalanceDetails.getCredit());
            existingBalance.setNmrCompte(newBalanceDetails.getNmrCompte());
            existingBalance.setDate(newBalanceDetails.getDate());

            return balanceRepo.save(existingBalance);
        } else {
            return null;
        }
    }

    public void deleteBalance(Long id) {
        balanceRepo.deleteById(id);
    }

    public List<Balance> getAllBalances() {
        return balanceRepo.findAll();
    }

    public List<Balance> getBalanceByExerciceId(Long exerciceId) {
        return balanceRepo.findByExerciceId(exerciceId);
    }
}
