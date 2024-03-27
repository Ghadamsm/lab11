package com.example.lab11.Repository;

import com.example.lab11.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment , Integer> {


    Comment findCommentByID(Integer Id);


    List<Comment> findCommentsByPostId(Integer Id);

}
