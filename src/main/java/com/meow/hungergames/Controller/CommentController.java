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
import org.springframework.web.bind.annotation.RequestBody;
import com.meow.hungergames.Entity.Comment;
import com.meow.hungergames.Service.CommentService;

@RestController
@RequestMapping("/api/commentService")
public class CommentController {
    
    @Autowired
    CommentService commentService;

    @PostMapping("/save")
    public String submitComment(@RequestBody Comment body) throws InterruptedException, ExecutionException {
        String result = commentService.submitCommentToDb(body);
        return result;
    }

    @GetMapping("/getComments/{postId}")
    public ArrayList<Comment> retrieveUserComment(@PathVariable("postId") String postId) throws InterruptedException, ExecutionException {
        ArrayList<Comment> result = commentService.retrievePostCommentFromDb(postId);
        return result;
    }

    @DeleteMapping("/delete/{postId}/{commentId}")
    public String deleteParticularComment(@PathVariable("postId") String postId, @PathVariable("commentId") String commentId) {
        String result = commentService.deleteCommentFromDb(postId, commentId);
        return result;
    }    
}