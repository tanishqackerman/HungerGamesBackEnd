package com.meow.hungergames.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.meow.hungergames.Entity.Post;
import com.meow.hungergames.Service.PostService;

@RestController
@RequestMapping("/api/postService")
public class PostController {

    @Autowired
    PostService postService;
    
    @PostMapping("/save")
    public String submitPost(@RequestBody Post body) throws InterruptedException, ExecutionException {
        String result = postService.submitPostToDb(body);
        return result;
    }
    
    @PutMapping("/update")
    public String updatePost(@RequestBody Post body) throws InterruptedException, ExecutionException {
        String result = postService.updatePostInDb(body);
        return result;
    }
    
    @GetMapping("/getPost")
    public ArrayList<Post> retrieveAllPost() throws InterruptedException, ExecutionException {
        ArrayList<Post> result = postService.retrievePostFromDb();
        return result;
    }
    
    @GetMapping("/getSinglePost/{postId}")
    public Post retrieveSinglePost(@PathVariable("postId") String postId) throws InterruptedException, ExecutionException {
        Post result = postService.retrieveSinglePostFromDb(postId);
        return result;
    }
    
    @GetMapping("/getPost/{userId}")
    public ArrayList<Post> retrieveUserPost(@PathVariable("userId") String userId) throws InterruptedException, ExecutionException {
        ArrayList<Post> result = postService.retrieveUserPostFromDb(userId);
        return result;
    }

    @GetMapping("/getPost/hottest")
    public ArrayList<Post> retrieveHottestPost() throws InterruptedException, ExecutionException {
        ArrayList<Post> result = postService.retrieveHottestPostFromDb();
        return result;
    }

    @GetMapping("/getPost/latest")
    public ArrayList<Post> retrieveLatestPost() throws InterruptedException, ExecutionException {
        ArrayList<Post> result = postService.retrieveLatestPostFromDb();
        return result;
    }

    @GetMapping("/getPost/veg")
    public ArrayList<Post> retrieveVegPost() throws InterruptedException, ExecutionException {
        ArrayList<Post> result = postService.retrieveVegPostFromDb();
        return result;
    }
    
    @GetMapping("/getPost/nonVeg")
    public ArrayList<Post> retrieveNonVegPost() throws InterruptedException, ExecutionException {
        ArrayList<Post> result = postService.retrieveNonVegPostFromDb();
        return result;
    }
    
    @GetMapping("/getPost/search/{query}")
    public ArrayList<Post> retrieveQueryPost(@PathVariable("query") String query) throws InterruptedException, ExecutionException {
        ArrayList<Post> result = postService.retrieveQueryPostFromDb(query);
        return result;
    }

    @DeleteMapping("/delete/{postId}")
    public String deleteParticularPost(@PathVariable("postId") String postId) {
        String result = postService.deletePostFromDb(postId);
        return result;
    }
}