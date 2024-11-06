package com.example.Project1.Service;
import com.example.Project1.Model.Accounts;
import com.example.Project1.Repository.Accountsrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AccountService {

    @Autowired
    Accountsrepo accountsrepo;
    public List<Accounts> getAccounts(){
        return accountsrepo.findAll();
    }
    public Accounts getAccountById(int id) {
        return accountsrepo.findById(id).orElseThrow(() -> new AccountNotFoundException("Account not found with id: " + id));
    }
    public class AccountNotFoundException extends RuntimeException {
        public AccountNotFoundException(String message) {
            super(message);
        }
    }
    

    public void addAccount(Accounts accounts){
        accountsrepo.save(accounts);
    }

    public void updateAccount(Accounts accounts){
        accountsrepo.save(accounts);
    }
    public void deleteAccount(int id) {
        accountsrepo.deleteById(id);
    }    
}

