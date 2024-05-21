package com.pfe.HRS.Controller;

import com.pfe.HRS.Model.GrandLivre;
import com.pfe.HRS.Model.JournalComptable;
import com.pfe.HRS.Service.GrandLivreS;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class GrandLivreC {
    @Autowired
    private final GrandLivreS grandLivreS;

    @PostMapping("/grand-livre/enregistrerF/{exerciceId}")
    public List<GrandLivre> enregistrerGrandLivre(@RequestBody List<GrandLivre> grandLivres , @PathVariable Long exerciceId) {
        List<GrandLivre> result = new ArrayList<>();
        for (GrandLivre grandLivre : grandLivres) {
            grandLivre.setExerciceId(exerciceId); // assuming Achat class has a method setExerciceId

            result.add(grandLivreS.enregistrerGrandLivre(grandLivre));
        }
        return result;
    }

    @GetMapping("/grand-livre/{id}")
    public GrandLivre getGrandLivreById(@PathVariable Long id) {
        return grandLivreS.getGrandLivreById(id);
    }

    @PutMapping("/grand-livre/{id}")
    public GrandLivre updateGrandLivre(@PathVariable Long id, @RequestBody GrandLivre newGrandLivreDetails) {
        return grandLivreS.updateGrandLivre(id, newGrandLivreDetails);
    }

    @DeleteMapping("/grand-livre/{id}")
    public void deleteGrandLivre(@PathVariable Long id) {
        grandLivreS.deleteGrandLivre(id);
    }

    @GetMapping("/grand-livre/all")
    public List<GrandLivre> getAllGrandLivres() {
        return grandLivreS.getAllGrandLivres();
    }


    @GetMapping("/grand-livre/exercice/{exercice_id}")
    public List<GrandLivre> getJournalsByExerciceId(@PathVariable Long exercice_id) {
        return grandLivreS.getJournalsByExerciceId(exercice_id);
    }


    @GetMapping("/grand-livreP/{idpiece}")
    public List<Long> getAchatIdByIdpieceAndTypepiece(@PathVariable Long idpiece) {
        List<Long> grandLivres = grandLivreS.findAchatIdByIdpieceAndTypepiece(idpiece);
        List<Long> ids = new ArrayList<>();
        if (grandLivreS != null) {
            for (Long grandLivre : grandLivres) {
                ids.add(grandLivre);
            }
        }
        return ids;
    }


}