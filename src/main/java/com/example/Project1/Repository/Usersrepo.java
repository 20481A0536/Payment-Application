package com.example.Project1.Repository;

import com.example.Project1.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Usersrepo extends JpaRepository<Users,Integer> {

}
