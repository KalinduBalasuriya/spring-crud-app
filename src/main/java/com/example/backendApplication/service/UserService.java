package com.example.backendApplication.service;

import com.example.backendApplication.model.AppUser;
import com.example.backendApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public AppUser saveUser(AppUser appUser){
        return userRepository.save(appUser);
    }

    public List<AppUser> getAllUsers(){
        return userRepository.getAllUsers();
    }

    public boolean deleteUser(Long id){
        return userRepository.deleteUser(id);
    }

    public AppUser updateUser(Long id,AppUser appUser){
        return userRepository.updateUser(id,appUser);
    }

}
