package com.pfe.HRS.Controller;


import com.pfe.HRS.Model.JournalDePaie;
import com.pfe.HRS.Service.JournalDePaieS;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class JournalDePaieC {
    @Autowired
    private final JournalDePaieS journalDePaieS;

    @PostMapping("/journal-de-paie/enregistrerF")
    public JournalDePaie enregistrerJournalDePaie(@RequestBody JournalDePaie journalDePaieM) {
        return journalDePaieS.enregistrerJournalDePaie(journalDePaieM);
    }

    @GetMapping("/journal-de-paie/{id}")
    public JournalDePaie getJournalDePaieById(@PathVariable Long id) {
        return journalDePaieS.getJournalDePaieById(id);
    }

    @PutMapping("/journal-de-paie/{id}")
    public JournalDePaie updateJournalDePaie(@PathVariable Long id, @RequestBody JournalDePaie newJournalDetails) {
        return journalDePaieS.updateJournalDePaie(id, newJournalDetails);
    }

    @DeleteMapping("/journal-de-paie/{id}")
    public void deleteJournalDePaie(@PathVariable Long id) {
        journalDePaieS.deleteJournalDePaie(id);
    }

    @GetMapping("/journal-de-paie/all")
    public List<JournalDePaie> getAllJournalDePaie() {
        return journalDePaieS.getAllJournalDePaies();
    }
}
