package com.example.Project1.Controller;


import com.example.Project1.Model.Users;
import com.example.Project1.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> createUser(@RequestBody Users user) {
        try {
            service.updateUsers(user);
            return ResponseEntity.ok("Account added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred: " + e.getMessage());
        }
    }

    @PutMapping("/users/update/{id}")
    public ResponseEntity<Users> updateUserById(@PathVariable int id, @RequestBody Users user){
        Users existingUser=service.getUsersById(id);
        if(existingUser!=null){
            user.setUserid(id);
            service.updateUsers(user);
            return ResponseEntity.ok(service.getUsersById(id));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        try {
            service.deleteUser(id);
            return ResponseEntity.ok("User deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error deleting user: " + e.getMessage());
        }
    }


}
