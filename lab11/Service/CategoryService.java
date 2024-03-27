package com.example.lab11.Service;

import com.example.lab11.API.ApiException;
import com.example.lab11.Model.Category;
import com.example.lab11.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {



    private final CategoryRepository categoryRepository ;



    public List<Category> getAll(){
        return categoryRepository.findAll();
    }


    public void addCategory(Category category){
        categoryRepository.save(category);
    }


    public void updateCategory(Integer Id , Category category){

        Category c = categoryRepository.findCategoryByID(Id);

        if (c == null){
            throw new ApiException("Invalid Id");
        }

        c.setName(category.getName());

        categoryRepository.save(c);

    }



    public void deleteCategory(Integer Id){

        Category c = categoryRepository.findCategoryByID(Id);

        if (c == null){
            throw new ApiException("Invalid Id");
        }

        categoryRepository.delete(c);

    }
}
