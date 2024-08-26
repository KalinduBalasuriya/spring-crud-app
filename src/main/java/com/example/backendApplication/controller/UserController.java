package com.example.backendApplication.controller;

import com.example.backendApplication.model.AppUser;

import com.example.backendApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


@PostMapping("createuser")
public AppUser createUser(@RequestBody AppUser user) {
    return userService.saveUser(user);
}

@GetMapping("getusers")
    public List<AppUser> getAllUsers(){
        return userService.getAllUsers();
}

@DeleteMapping("user/deleteuser/{id}")
    public String deleteUser(@PathVariable Long id) {
         userService.deleteUser(id);
         System.out.println(userService.deleteUser(id));
         return "User deleted";

}


@PutMapping("user/updateuser/{id}")
public AppUser updateUser(@PathVariable Long id, @RequestBody AppUser user) {
    return userService.updateUser(id, user);
}

}
