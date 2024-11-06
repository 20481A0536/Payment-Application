package com.example.Project1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project1.Model.Accounts;
import com.example.Project1.Service.*;

@RestController
@RequestMapping("/api/payment")
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

    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable int id) {
        try {
            service.deleteAccount(id);
            return ResponseEntity.ok("Account deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error deleting account: " + e.getMessage());
        }
    }

    @GetMapping("/accounts/balance/{id}")
    public ResponseEntity<Long> checkBalance(@PathVariable int id) {
        Accounts account = service.getAccountById(id);
        if (account != null) {
            return ResponseEntity.ok(account.getBalance());
        }
        return ResponseEntity.notFound().build();
    }
}
