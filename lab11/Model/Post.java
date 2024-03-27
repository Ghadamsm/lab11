package com.example.lab11.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
public class Post {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer ID ;


    @Column(columnDefinition = "int not null")
   private Integer categoryId ;


    @NotEmpty(message = "title id should be not empty")
    @Size(min = 4 , message = "title should be more than 4 char")
    @Column(columnDefinition = "varchar(40) not null")
   private String title ;


    @NotEmpty(message = "content id should be not empty")
    @Size(min = 4 , message = "content should be more than 4 char")
    @Column(columnDefinition = "varchar(250) not null")
   private String content ;


    @Column(columnDefinition = "int not null")
   private Integer userId ;


    @DateTimeFormat
    @Column(columnDefinition = "date")
   private LocalDate publishDate ;


}
