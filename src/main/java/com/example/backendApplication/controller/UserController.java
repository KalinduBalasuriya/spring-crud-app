package com.example.backendApplication.controller;

import com.example.backendApplication.model.AppUser;
import com.example.backendApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("createuser")
    AppUser newAppUser(@RequestBody AppUser appUser) {
        return userRepository.save(appUser);
    }

@GetMapping("getusers")
    List<AppUser> getAllUsers(){
        return userRepository.findAll();
}

@DeleteMapping("user/deleteuser/{id}")
    public String deleteUser(@PathVariable Long id) {
    if (userRepository.existsById(id)) {
        userRepository.deleteById(id);
        return String.format("User %d deleted successfully!", id);
    }else {
        return "User not found";
    }

}

@PutMapping("user/updateuser/{id}")
public ResponseEntity<AppUser> updateUser(@PathVariable Long id, @RequestBody AppUser appUser) {
    if (userRepository.existsById(id)) {
        return userRepository.findById(id).map(user -> {
            user.setName(appUser.getName());
            user.setEmail(appUser.getEmail());
            user.setUsername(appUser.getUsername());
            // Save the updated user and return it
            AppUser updatedUser = userRepository.save(user);
            return ResponseEntity.ok(updatedUser);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    } else {
        return ResponseEntity.notFound().build();
    }
}
}
