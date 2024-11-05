package com.example.Project1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project1.Model.Accounts;
import com.example.Project1.Service.*;

@RestController
public class AccountsController {
    @Autowired
    AccountService service;

    @GetMapping("/accounts")
    public List<Accounts> geAccounts(){
        return service.getAccounts();
    }

    @GetMapping("/accounts/{id}")
    public Accounts getAccountById(@PathVariable int id){
        return service.getAccountById(id);
    }

    @PostMapping("/accounts/additem")
public ResponseEntity<String> createAccount(@RequestBody Accounts acc) {
    try {
        service.updateAccount(acc);
        return ResponseEntity.ok("Account added successfully");
    } catch (Exception e) {
        return ResponseEntity.status(500).body("An error occurred: " + e.getMessage());
    }
}


    @PutMapping("/accounts/update/{id}")
    public ResponseEntity<Accounts> updateAccountById(@PathVariable int id, @RequestBody Accounts acc){
        Accounts account=service.getAccountById(id);
        if(account!=null){
            acc.setAccount_id(id);
            service.updateAccount(account);
            return ResponseEntity.ok(service.getAccountById(id));
        }
        return ResponseEntity.notFound().build();
    }
}
