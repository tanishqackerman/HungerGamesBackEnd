package com.meow.hungergames.Controller;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meow.hungergames.Service.LikeService;
import com.meow.hungergames.Entity.Like;

@RestController
@RequestMapping("/api/likeService")
public class LikeController {
    
    @Autowired
    LikeService likeService;

    @PostMapping("/save")
    public String submitLike(@RequestBody Like body) throws InterruptedException, ExecutionException {
        String result = likeService.submitLikeToDb(body);
        return result;
    }

    @GetMapping("/getLikes/{postId}")
    public ArrayList<Like> retrievePostLike(@PathVariable("postId") String postId) throws InterruptedException, ExecutionException {
        ArrayList<Like> result = likeService.retrieveLikeFromDb(postId);
        return result;
    }
    
    @GetMapping("/getLikes/{postId}/{userId}")
    public Like checkIfUserLiked(@PathVariable("postId") String postId, @PathVariable("userId") String userId) throws InterruptedException, ExecutionException {
        Like result = likeService.checkLikeFromDb(postId, userId);
        return result;
    }

    @DeleteMapping("/delete/{postId}/{userId}")
    public String deleteLike(@PathVariable("postId") String postId, @PathVariable("userId") String userId) {
        String result = likeService.deleteLikeFromDb(postId, userId);
        return result;
    }
}