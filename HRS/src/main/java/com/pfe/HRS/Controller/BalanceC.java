package com.pfe.HRS.Controller;

import com.pfe.HRS.Model.Balance;
import com.pfe.HRS.Service.BalanceS;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class BalanceC {
    @Autowired
    private final BalanceS balanceS;

    @PostMapping("/Balance/enregistrer/{exerciceId}")
    public List<Balance> enregistrer(@RequestBody List<Balance> balances , @PathVariable Long exerciceId) {
        List<Balance> result = new ArrayList<>();
        for (Balance balance : balances) {
            balance.setExerciceId(exerciceId); // assuming Achat class has a method setExerciceId
            result.add(balanceS.enregistrerBalance(balance));
        }
        return result;
    }

    @GetMapping("/Balance/{id}")
    public Balance getBalanceById(@PathVariable Long id) {
        return balanceS.getBalanceById(id);
    }

    @PutMapping("/Balance/{id}")
    public Balance updateBalance(@PathVariable Long id, @RequestBody Balance newBalanceDetails) {
        return balanceS.updateBalance(id, newBalanceDetails);
    }

    @DeleteMapping("/Balance/{id}")
    public void deleteBalance(@PathVariable Long id) {
        balanceS.deleteBalance(id);
    }

    @GetMapping("/Balance/all")
    public List<Balance> getAllBalances() {
        return balanceS.getAllBalances();
    }

    @GetMapping("/Balance/exercice/{exerciceId}")
    public List<Balance> getBalanceByExerciceId(@PathVariable Long exerciceId) {
        return balanceS.getBalanceByExerciceId(exerciceId);
    }

}