package com.pfe.HRS.Controller;

import com.pfe.HRS.Model.Exercice;
import com.pfe.HRS.Service.ExerciceS;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class ExerciceC {
    @Autowired
    private final ExerciceS exerciceS;

    @PostMapping("/Exercice/enregistrer")
    public List<Exercice> enregistrerExercice(@RequestBody List<Exercice> exercices) {
        List<Exercice> result = new ArrayList<>();
        for (Exercice exercice : exercices) {
            result.add(exerciceS.enregistrerExercice(exercice));
        }
        return result;
    }

    @GetMapping("/Exercice/{id}")
    public Exercice getExerciceById(@PathVariable Long id) {
        return exerciceS.getExerciceById(id);
    }

    @PutMapping("/Exercice/{id}")
    public Exercice updateExercice(@PathVariable Long id, @RequestBody Exercice newExerciceDetails) {
        return exerciceS.updateExercice(id, newExerciceDetails);
    }

    @DeleteMapping("/Exercice/{id}")
    public void deleteExercice(@PathVariable Long id) {
        exerciceS.deleteExercice(id);
    }

    @GetMapping("/Exercice/all")
    public List<Exercice> getAllExercices() {
        return exerciceS.getAllExercices();
    }
    @GetMapping("/Exercice/year/{year}")
    public List<Exercice> getExercisesByYear(@PathVariable int year) {

        return exerciceS.getExercisesByYear(year);
    }
    @PostMapping("/Exercice/create/{year}")
    public Exercice createExercice(@PathVariable int year) {
        return exerciceS.createExercice(year);
    }
    @GetMapping("/Exercice/id/{year}")
    public List<Long> getExerciceIdByYear(@PathVariable int year) {
        List<Exercice> exercices = exerciceS.getExercisesByYear(year); // corrected here
        List<Long> ids = new ArrayList<>();
        if (exercices != null) {
            for (Exercice exercice : exercices) {
                ids.add(exercice.getId());
            }
        }
        return ids;
    }
}