package com.meow.hungergames.Controller;

import java.util.concurrent.ExecutionException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meow.hungergames.Entity.User;
import com.meow.hungergames.Service.UserService;

@RestController
@RequestMapping("api/userService")
public class UserController {
    
    @Autowired
    UserService userService;

    @PostMapping("/save")
    public String submitPost(@RequestBody User body) throws InterruptedException, ExecutionException {
        String result = userService.submitUserToDb(body);
        return result;
    }

    @GetMapping("/getUserDetails")
    public ArrayList<User> retrieveUserDetails() throws InterruptedException, ExecutionException {
        ArrayList<User> result = userService.retrieveUserDetailsFromDb();
        return result;
    }

    @GetMapping("/getUserDetails/{userId}")
    public User retrieveUser(@PathVariable("userId") String userId) throws InterruptedException, ExecutionException {
        User result = userService.retrieveUserFromDb(userId);
        return result;
    }

    @DeleteMapping("/delete/{userId}")
    public String deleteParticularPost(@PathVariable("userId") String userId) {
        String result = userService.deleteUserFromDb(userId);
        return result;
    }
}