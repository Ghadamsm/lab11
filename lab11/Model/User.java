package com.example.lab11.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID ;


    @NotEmpty(message = "username should be not empty")
    @Size(min = 4 , message = "username should be more than 4 char")
    @Column(columnDefinition = "varchar(10) not null")
    private String Username ;


    @NotEmpty(message = "password should be not empty")
    @Size(min = 5 , message = "password should be more than 4 char")
    @Column(columnDefinition = "varchar(15) not null unique")
    private String password ;


    @Email
    @NotEmpty(message = "email should be not empty")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String email ;



    @DateTimeFormat
    @Column(columnDefinition = "date")
    private LocalDate registrationDate ;




}
