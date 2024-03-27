package com.example.lab11.Repository;

import com.example.lab11.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface PostRepository extends JpaRepository<Post , Integer> {



    Post findPostByID(Integer Id);


    List<Post> findPostsByUserId(Integer Id);


    Post findPostByTitle(String title);


    List<Post> findPostsByPublishDateBefore(LocalDate date);


    @Query("select c from Post c where c.categoryId =?1 and c.userId =?2")
    Post getByUIdAndCId(Integer CId , Integer UId);





    List<Post> getPostsByCategoryId(Integer Id);


    @Query("select c from Post c where c.ID =? 1 and c.publishDate =? 2")
    List<Post> getPostByIDAndDate(Integer Id , LocalDate date);


}
