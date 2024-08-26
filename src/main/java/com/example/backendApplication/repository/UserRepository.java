package com.example.backendApplication.repository;

import com.example.backendApplication.model.AppUser;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository{

    private final List<AppUser> users= new ArrayList<AppUser>();
private long idCounter =1;
    public List<AppUser> getAllUsers(){
        return users;
    }

    public AppUser save(AppUser user){

        AppUser a = new AppUser();
        a.setName(user.getName());
        a.setUsername(user.getUsername());
        a.setEmail(user.getEmail());
        a.setId(idCounter);
        users.add(a);
        idCounter++;
        return a;
    }

    public AppUser updateUser(Long id,AppUser appuser) {
        Optional<AppUser> user = users.stream().filter(u -> u.getId() == id).findFirst();

        user.ifPresent(a->{

            a.setName(appuser.getName());
            a.setUsername(appuser.getUsername());
            a.setEmail(appuser.getEmail());
        });
        return user.orElse(null);
    }
    public boolean deleteUser (Long id){
        Optional<AppUser> user = users.stream().filter(u -> u.getId() == id).findFirst();
        if(user.isPresent()){
            users.remove(user.get());

            return true;
        }else{
            return false;
        }

    }

}
