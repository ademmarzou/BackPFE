package com.pfe.HRS.Controller;

import com.pfe.HRS.Model.Achat;
import com.pfe.HRS.Model.JournalComptable;
import com.pfe.HRS.Service.JournalComptableS;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class JournalComptableC {
    @Autowired
    private final JournalComptableS journalComptableS;

    @PostMapping("/journal-comptable/enregistrerF")
    public JournalComptable enregistrerJournalComptable(@RequestBody JournalComptable journalComptableM) {
        return journalComptableS.enregistrerJournalComptable(journalComptableM);
    }

    @GetMapping("/journal-comptable/{id}")
    public JournalComptable getJournalComptableById(@PathVariable Long id) {
        return journalComptableS.getJournalComptableById(id);
    }

    @PutMapping("/journal-comptable/{id}")
    public JournalComptable updateJournalComptable(@PathVariable Long id, @RequestBody JournalComptable newJournalDetails) {
        return journalComptableS.updateJournalComptable(id, newJournalDetails);
    }

    @DeleteMapping("/journal-comptable/{id}")
    public void deleteJournalComptable(@PathVariable Long id) {
        journalComptableS.deleteJournalComptable(id);
    }

    @GetMapping("/journal-comptable/all")
    public List<JournalComptable> getAllJournalComptables() {
        return journalComptableS.getAllJournalComptables();
    }



}
