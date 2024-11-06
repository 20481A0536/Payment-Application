package com.example.Project1.Service;

import com.example.Project1.Model.Users;
import com.example.Project1.Repository.Usersrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsersService {
    @Autowired
    Usersrepo usersrepo;
    public List<Users> getUsers(){
        return usersrepo.findAll();
    }
    public Users getUsersById(int id){
        return usersrepo.findById(id).orElseThrow(()-> new UserNotFoundException("User not found with id:"+id));
    }
    public class UserNotFoundException extends RuntimeException {
        public UserNotFoundException(String message) {
            super(message);
        }
    }
    

    public void addUsers(Users user){
        usersrepo.save(user);
    }

    public void updateUsers(Users user){
        usersrepo.save(user);
    }

    public void deleteUser(int id){
        usersrepo.deleteById(id);
    }
}
