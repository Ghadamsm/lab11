package com.example.lab11.Service;


import com.example.lab11.API.ApiException;
import com.example.lab11.Model.User;
import com.example.lab11.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository ;


    public List<User> getAll(){
        return userRepository.findAll();
    }


    public void addUser(User user){
        user.setRegistrationDate(LocalDate.now());
        userRepository.save(user);
    }


    public void updateUser(Integer Id , User user){

        User u = userRepository.findUserByID(Id);

        if (u == null){
            throw new ApiException("Invalid Id");
        }

        u.setUsername(user.getUsername());
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());
        u.setRegistrationDate(user.getRegistrationDate());

        userRepository.save(u);

    }



    public void deleteUser(Integer Id){

        User u = userRepository.findUserByID(Id);

        if (u == null){
            throw new ApiException("Invalid Id");
        }

        userRepository.delete(u);

    }



    //                                                                   Extra


    public List<User> getIdBetween(Integer FId , Integer SId){

        List<User> u = userRepository.findUsersByIDBetween(FId , SId);

        if (u == null){
            throw new ApiException("Invalid Ids");
        }

        return u ;

    }








}
