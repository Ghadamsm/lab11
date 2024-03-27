package com.example.lab11.Repository;

import com.example.lab11.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User , Integer> {


    User findUserByID (Integer Id);



    List<User> findUsersByIDBetween(Integer firstId , Integer secondId);


}
