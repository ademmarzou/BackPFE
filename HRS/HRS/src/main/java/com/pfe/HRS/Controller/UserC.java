package com.pfe.HRS.Controller;


import com.pfe.HRS.Model.User;
import com.pfe.HRS.Service.UserS;
import com.pfe.HRS.Service.jwt.UserSImpl;
import com.pfe.HRS.utils.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserC {
    @Autowired

    private final UserS userS;
    private final UserSImpl userSI;


    private final JwtUtil jwtUtil;

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return userS.enregistrerUser(user);
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id) {
        return userS.getUserById(id);
    }

    @PutMapping("/user{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User newUser) {
        return userS.updateUser(id, newUser);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        userS.deleteUser(id);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userS.getAllUsers();
    }



}