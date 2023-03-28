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

import com.meow.hungergames.Entity.Saved;
import com.meow.hungergames.Service.SavedService;

@RestController
@RequestMapping("api/savedService")
public class SavedController {
    
    @Autowired
    SavedService savedService;

    @PostMapping("/save")
    public String submitPost(@RequestBody Saved body) throws InterruptedException, ExecutionException {
        String result = savedService.submitSavedToDb(body);
        return result;
    }

    @GetMapping("/getSaved/{userId}")
    public ArrayList<Saved> retrieveUserPost(@PathVariable("userId") String userId) throws InterruptedException, ExecutionException {
        ArrayList<Saved> result = savedService.retrieveSavedFromDb(userId);
        return result;
    }

    @GetMapping("/getSaved/{userId}/{postId}")
    public Saved checkIfUserLiked(@PathVariable("postId") String postId, @PathVariable("userId") String userId) throws InterruptedException, ExecutionException {
        Saved result = savedService.checkSavedFromDb(postId, userId);
        return result;
    }

    @DeleteMapping("/delete/{userId}/{postId}")
    public String deleteParticularPost(@PathVariable("userId") String userId, @PathVariable("postId") String postId) {
        String result = savedService.deleteSavedFromDb(userId, postId);
        return result;
    }
}
