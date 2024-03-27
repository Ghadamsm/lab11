package com.example.lab11.Controller;


import com.example.lab11.API.ApiResponse;
import com.example.lab11.Model.User;
import com.example.lab11.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService ;

    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(userService.getAll());
    }



    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user , Errors errors){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("User added"));

    }



    @PutMapping("/update/{Id}")
    public ResponseEntity updateUser(@PathVariable Integer Id , @RequestBody @Valid User user , Errors errors){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        userService.updateUser(Id , user);

        return ResponseEntity.status(200).body(new ApiResponse("user updated"));
    }



    @DeleteMapping("/delete/{Id}")
    public ResponseEntity deleteUser(@PathVariable Integer Id ){

        userService.deleteUser(Id);

        return ResponseEntity.status(200).body(new ApiResponse("User deleted"));
    }



    //                                                                   Extra



    @GetMapping("/getBetween/{FId}/{SId}")
    public ResponseEntity getIdBetween (@PathVariable Integer FId ,@PathVariable Integer SId){
        return ResponseEntity.status(200).body(userService.getIdBetween(FId, SId));
    }



}
