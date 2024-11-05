package com.example.Project1.Controller;

import com.example.Project1.Model.Users;
import com.example.Project1.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
public class UsersController {
    @Autowired
    UsersService service;

    @GetMapping("/users")
    public List<Users> getUsers(){
        return service.getUsers();
    }

    @GetMapping("/users/{id}")
    public Users getUserById(@PathVariable int id){
        return service.getUsersById(id);
    }

    @PostMapping("/users/additem")
    public void addUsers(@RequestBody Users user){
        service.addUsers(user);
    }

    @PutMapping("/users/update")
    public void updateUsers(@RequestBody Users user){
        service.updateUsers(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUsers(@PathVariable int id){
        service.deleteUser(id);
    }

}
