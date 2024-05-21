package com.pfe.HRS.Service;

import com.pfe.HRS.Model.User;
import com.pfe.HRS.Repository.UserRepo;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Builder
@Service
public class UserS {

    private final UserRepo userRepo;

    @Autowired
    public UserS(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    // Créer un nouvel utilisateur
    public User enregistrerUser(User user) {
        return userRepo.save(user);
    }

    // Récupérer un utilisateur par son ID
    public User getUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }


    // Mettre à jour un utilisateur
// Mettre à jour un utilisateur
    public User updateUser(Long userId, User newUserDetails) {
        User existingUser = userRepo.findById(userId).orElse(null);
        if (existingUser != null) {
            // Mettez à jour les attributs selon vos besoins
            existingUser.setUsername(newUserDetails.getUsername());
            existingUser.setEmail(newUserDetails.getEmail());
            existingUser.setPassword(newUserDetails.getPassword());
            return userRepo.save(existingUser);
        } else {
            return null;
        }
    }


    // Supprimer un utilisateur par son ID
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    // Récupérer tous les utilisateurs
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}

