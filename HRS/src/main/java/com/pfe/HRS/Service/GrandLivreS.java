package com.pfe.HRS.Service;


import com.pfe.HRS.Model.GrandLivre;
import com.pfe.HRS.Model.JournalComptable;
import com.pfe.HRS.Repository.GrandLivreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrandLivreS {

    private final GrandLivreRepo grandLivreRepo;

    @Autowired
    public GrandLivreS(GrandLivreRepo grandLivreRepo) {
        this.grandLivreRepo = grandLivreRepo;
    }

    // Créer un nouveau grand livre
    public GrandLivre enregistrerGrandLivre(GrandLivre grandLivre) {
        return grandLivreRepo.save(grandLivre);
    }

    // Récupérer un grand livre par son ID
    public GrandLivre getGrandLivreById(Long id) {
        return grandLivreRepo.findById(id).orElse(null);
    }

    // Mettre à jour un grand livre
    public GrandLivre updateGrandLivre(Long grandLivreId, GrandLivre newGrandLivreDetails) {
        GrandLivre existingGrandLivre = grandLivreRepo.findById(grandLivreId).orElse(null);
        if (existingGrandLivre != null) {
            // Mettez à jour les attributs selon vos besoins
            existingGrandLivre.setNmrCompte(newGrandLivreDetails.getNmrCompte());
            existingGrandLivre.setId(newGrandLivreDetails.getId());
            existingGrandLivre.setCredit(newGrandLivreDetails.getCredit());
            existingGrandLivre.setDate(newGrandLivreDetails.getDate());
            existingGrandLivre.setDebit(newGrandLivreDetails.getDebit());

            return grandLivreRepo.save(existingGrandLivre);
        } else {
            return null;
        }
    }

    // Supprimer un grand livre par son ID
    public void deleteGrandLivre(Long id) {
        grandLivreRepo.deleteById(id);
    }

    // Récupérer tous les grands livres
    public List<GrandLivre> getAllGrandLivres() {
        return grandLivreRepo.findAll();
    }
    public List<GrandLivre> getJournalsByExerciceId(Long exerciceId) {
        return grandLivreRepo.findByExerciceId(exerciceId);
    }
    public void deleteGrandLivreP(Long idpiece) {
        // Fetch the grand livre based on idpiece and typepiece
        GrandLivre grandLivre = (GrandLivre) grandLivreRepo.findAchatIdByIdpieceAndTypepiece(idpiece );
        if (grandLivre != null) {
            // Delete the grand livre
            grandLivreRepo.delete(grandLivre);

        } else {
            throw new RuntimeException("Grand Livre not found with idpiece: " + idpiece );
        }
    }
    public List<Long> findAchatIdByIdpieceAndTypepiece(Long idpiece) {
        return grandLivreRepo.findAchatIdByIdpieceAndTypepiece(idpiece);
    }
}