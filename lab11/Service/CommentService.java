package com.example.lab11.Service;


import com.example.lab11.API.ApiException;
import com.example.lab11.Model.Comment;
import com.example.lab11.Model.Post;
import com.example.lab11.Model.User;
import com.example.lab11.Repository.CommentRepository;
import com.example.lab11.Repository.PostRepository;
import com.example.lab11.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {



    private final CommentRepository commentRepository ;
    private final UserRepository userRepository ;
    private final PostRepository postRepository ;



    public List<Comment> getAll(){
        return commentRepository.findAll();
    }


    public void addComment(Integer UId , Integer PId , Comment comment){

        User u = userRepository.findUserByID(UId);
        Post p = postRepository.findPostByID(PId);

        if (u == null && p == null){
            throw new ApiException("Invalid id");
        }

        comment.setCommentDate(LocalDate.now());
        commentRepository.save(comment);
    }


    public void updateComment(Integer Id , Comment comment){

        Comment c = commentRepository.findCommentByID(Id);

        if (c == null){
            throw new ApiException("Invalid Id");
        }

        c.setContent(comment.getContent());
        c.setCommentDate(comment.getCommentDate());
        c.setPostId(comment.getPostId());
        c.setUserId(comment.getUserId());

        commentRepository.save(c);

    }



    public void deleteComment(Integer Id){

        Comment c = commentRepository.findCommentByID(Id);

        if (c == null){
            throw new ApiException("Invalid Id");
        }

        commentRepository.delete(c);

    }



//                                                                   Extra

    public List<Comment> getAllByPID(Integer Id){

        List<Comment> c = commentRepository.findCommentsByPostId(Id);

        if (c == null){
            throw new ApiException("Invalid post Id");
        }

        return c ;

    }
}
