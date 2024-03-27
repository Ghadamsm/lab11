package com.example.lab11.Controller;


import com.example.lab11.API.ApiResponse;
import com.example.lab11.Model.Post;
import com.example.lab11.Service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class PostController {



    private final PostService postService ;

    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(postService.getAll());
    }



    @PostMapping("/add")
    public ResponseEntity addPost(@RequestBody @Valid Post post , Errors errors){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        postService.addPost(post);
        return ResponseEntity.status(200).body(new ApiResponse("post added"));

    }



    @PutMapping("/update/{Id}")
    public ResponseEntity updatePost(@PathVariable Integer Id , @RequestBody @Valid Post post , Errors errors){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        postService.updatePost(Id , post);

        return ResponseEntity.status(200).body(new ApiResponse("Post updated"));
    }



    @DeleteMapping("/delete/{Id}")
    public ResponseEntity deletePost(@PathVariable Integer Id ){

        postService.deletePost(Id);

        return ResponseEntity.status(200).body(new ApiResponse("Post deleted"));
    }




    //                                                                   Extra


    @GetMapping("/getP/{Id}")
    public ResponseEntity getAllPost(@PathVariable Integer Id){
        return ResponseEntity.status(200).body(postService.getAllPost(Id));
    }



    @GetMapping("/getP/{title}")
    public ResponseEntity getPostByTitle(@PathVariable String title){
        return ResponseEntity.status(200).body(postService.getPostByTitle(title));
    }



    @GetMapping("/getBefore/{date}")
    public ResponseEntity getAllBeforeDate(@PathVariable LocalDate date){
        return ResponseEntity.status(200).body(postService.getAllBeforeDate(date));
    }



    @GetMapping("/getP/{CId}/{UId}")
    public ResponseEntity getPostByUIdAndCId(@PathVariable Integer CId ,@PathVariable Integer UId){
        return ResponseEntity.status(200).body(postService.getPostByUIdAndCId(CId , UId));
    }



    @GetMapping("/getCat/{CId}")
    public ResponseEntity getPostByCID(@PathVariable Integer CId){
        return ResponseEntity.status(200).body(postService.getPostByCID(CId));
    }




    @GetMapping("/getById-date/{Id}/{date}")
    public ResponseEntity getPostByIDAndDate (@PathVariable Integer Id , @PathVariable LocalDate date ){
        return ResponseEntity.status(200).body(postService.getPostByIDAndDate(Id, date));
    }
}
