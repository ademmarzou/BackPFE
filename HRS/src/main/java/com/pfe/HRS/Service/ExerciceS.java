package com.pfe.HRS.Service;

import com.pfe.HRS.Model.Exercice;
import com.pfe.HRS.Repository.ExerciceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class ExerciceS {

    private final ExerciceRepo exerciceRepo;

    @Autowired
    public ExerciceS(ExerciceRepo exerciceRepo) {
        this.exerciceRepo = exerciceRepo;
    }

    // Enregistrer un nouvel exercice
    public Exercice enregistrerExercice(Exercice exercice) {
        return exerciceRepo.save(exercice);
    }

    // Récupérer un exercice par son ID
    public Exercice getExerciceById(Long id) {
        return exerciceRepo.findById(id).orElse(null);
    }

    // Mettre à jour un exercice
    public Exercice updateExercice(Long id, Exercice newExerciceDetails) {
        Exercice existingExercice = exerciceRepo.findById(id).orElse(null);
        if (existingExercice != null) {
            existingExercice.setId(newExerciceDetails.getId());
            existingExercice.setDate(newExerciceDetails.getDate());


            return exerciceRepo.save(existingExercice);
        } else {
            return null;
        }
    }

    // Supprimer un exercice par son ID
    public void deleteExercice(Long id) {
        exerciceRepo.deleteById(id);
    }

    // Récupérer tous les exercices
    public List<Exercice> getAllExercices() {
        return exerciceRepo.findAll();
    }
    public Exercice createExercice(int year) {
        Exercice exercice = new Exercice();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        exercice.setDate(calendar.getTime());
        return exerciceRepo.save(exercice);
    }


    public List<Exercice> getExercisesByYear(int year) {
        return exerciceRepo.findByYear(year);
    }

    public Exercice getExerciceByYear(int year) {
        List<Exercice> exercices = exerciceRepo.findByYear(year);
        if (!exercices.isEmpty()) {
            return exercices.get(0); // return the first Exercice in the list
        } else {
            return null; // or throw an exception, depending on your use case
        }
    }

    public List<Long> getExerciceIdByYear(@PathVariable int year) {
        List<Exercice> exercices = getExercisesByYear(year);
        List<Long> ids = new ArrayList<>();
        if (exercices != null) {
            for (Exercice exercice : exercices) {
                ids.add(exercice.getId());
            }
        }
        return ids;
    }

}