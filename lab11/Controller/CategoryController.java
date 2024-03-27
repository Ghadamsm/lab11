package com.example.lab11.Controller;


import com.example.lab11.API.ApiResponse;
import com.example.lab11.Model.Category;
import com.example.lab11.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {


    private final CategoryService categoryService ;



    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(categoryService.getAll());
    }



    @PostMapping("/add")
    public ResponseEntity addCategory(@RequestBody @Valid Category category , Errors errors){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        categoryService.addCategory(category);
        return ResponseEntity.status(200).body(new ApiResponse("Category added"));

    }



    @PutMapping("/update/{Id}")
    public ResponseEntity updateCategory(@PathVariable Integer Id , @RequestBody @Valid Category category , Errors errors){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        categoryService.updateCategory(Id , category);

        return ResponseEntity.status(200).body(new ApiResponse("Category updated"));
    }



    @DeleteMapping("/delete/{Id}")
    public ResponseEntity deleteCategory(@PathVariable Integer Id ){

        categoryService.deleteCategory(Id);

        return ResponseEntity.status(200).body(new ApiResponse("Category deleted"));
    }




    //                                                                   Extra



}
