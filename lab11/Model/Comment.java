package com.example.lab11.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Comment {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID ;


    @NotNull(message = "user id should be not empty")
    @Column(columnDefinition = "int not null")
    private Integer userId ;


    @NotNull(message = "post id should be not empty")
    @Column(columnDefinition = "int not null")
    private Integer postId ;


    @NotEmpty(message = "content should be not empty")
    @Size(min = 15 , message = "content should be more than 15 char")
    @Column(columnDefinition = "varchar(150) not null")
    private String content ;


    @DateTimeFormat
    @Column(columnDefinition = "date")
    private LocalDate commentDate ;

}
