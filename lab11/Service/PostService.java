package com.example.lab11.Service;


import com.example.lab11.API.ApiException;
import com.example.lab11.Model.Category;
import com.example.lab11.Model.Post;
import com.example.lab11.Model.User;
import com.example.lab11.Repository.CategoryRepository;
import com.example.lab11.Repository.PostRepository;
import com.example.lab11.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {



    private final PostRepository postRepository ;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;


    public List<Post> getAll(){
        return postRepository.findAll();
    }


    public void addPost(Post post){

     Category c = categoryRepository.findCategoryByID(post.getCategoryId());
     User u = userRepository.findUserByID(post.getUserId());

        if (c == null ) {
            if (u == null) {
                throw new ApiException("Invalid user Id");
            }
            throw new ApiException("Invalid category Id");
        }

        post.setPublishDate(LocalDate.now());
        postRepository.save(post);
    }


    public void updatePost(Integer Id , Post post){

        Post p = postRepository.findPostByID(Id);

        if (p == null){
            throw new ApiException("Invalid Id");
        }

        p.setContent(post.getContent());
        p.setTitle(post.getTitle());
        p.setCategoryId(post.getCategoryId());
        p.setUserId(post.getUserId());
        p.setPublishDate(post.getPublishDate());


        postRepository.save(p);

    }



    public void deletePost(Integer Id){

        Post p = postRepository.findPostByID(Id);

        if (p == null){
            throw new ApiException("Invalid Id");
        }

        postRepository.delete(p);

    }




//                                                                   Extra


    public List<Post> getAllPost(Integer Id){

        List<Post> p = postRepository.findPostsByUserId(Id);

        if (p == null ){
            throw new ApiException("Invalid Id");
        }


        return p ;

    }



    public Post getPostByTitle(String title){
        Post p = postRepository.findPostByTitle(title);

        if (p == null){
            throw new ApiException("Invalid title");
        }

        return p ;

    }



    public List<Post> getAllBeforeDate(LocalDate date){

        List<Post> posts = postRepository.findPostsByPublishDateBefore(date);

        if (posts == null){
            throw new ApiException("Invalid date");
        }

        return posts ;

    }



    public Post getPostByUIdAndCId(Integer CId , Integer UId ){

        Post p = postRepository.getByUIdAndCId(CId , UId);
        if (p == null){
            throw new ApiException("Invalid user id or category id");
        }

        return p ;

    }



    public List<Post> getPostByCID(Integer CId){

        List<Post> p = postRepository.getPostsByCategoryId(CId);

        if (p == null ){
            throw new ApiException("Invalid Id");
        }

        return p;
    }




    public List<Post> getPostByIDAndDate (Integer Id , LocalDate date){

        List<Post> p = postRepository.getPostByIDAndDate(Id, date);

        if (p == null){
            throw new ApiException("Invalid");
        }

        return p ;

    }
}
