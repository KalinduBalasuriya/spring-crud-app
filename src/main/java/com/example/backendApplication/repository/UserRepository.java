package com.example.backendApplication.repository;

import com.example.backendApplication.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser,Long> {

}
