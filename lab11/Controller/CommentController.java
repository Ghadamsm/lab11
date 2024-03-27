package com.example.lab11.Controller;


import com.example.lab11.API.ApiResponse;
import com.example.lab11.Model.Comment;
import com.example.lab11.Service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comment")
@RequiredArgsConstructor
public class CommentController {


    private final CommentService commentService ;




    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(commentService.getAll());
    }



    @PostMapping("/add")
    public ResponseEntity addComment( @RequestBody @Valid Comment comment , Errors errors){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        commentService.addComment(comment);
        return ResponseEntity.status(200).body(new ApiResponse("Comment added"));

    }



    @PutMapping("/update/{Id}")
    public ResponseEntity updateComment(@PathVariable Integer Id , @RequestBody @Valid Comment comment , Errors errors){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        commentService.updateComment(Id , comment);

        return ResponseEntity.status(200).body(new ApiResponse("Comment updated"));
    }



    @DeleteMapping("/delete/{Id}")
    public ResponseEntity deleteComment(@PathVariable Integer Id ){

        commentService.deleteComment(Id);

        return ResponseEntity.status(200).body(new ApiResponse("Comment deleted"));
    }


    @GetMapping("/getId/{Id}")
    public ResponseEntity getAllByPostID(@PathVariable Integer Id){

        return ResponseEntity.status(200).body(commentService.getAllByPID(Id));
    }

}
