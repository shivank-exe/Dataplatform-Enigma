package com.airtel.digital.dataplatform.controller;

import com.airtel.digital.dataplatform.Entity.User;
import com.airtel.digital.dataplatform.Service.UserService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User addUser(@RequestParam  @NotNull Long teamId, @RequestBody User user){
        return userService.addUser(teamId,user);
    }
    @GetMapping
    public List<User> fetchAllUsers(){
        return userService.fetchAllUsers();
    }

    @GetMapping("/{id}")
    public User fetchUserById(@PathVariable("id") Long userId){
        return userService.fetchUserById(userId);
    }
    @PutMapping("/{id}")
    public User updateUserDetails(@PathVariable("id") Long userId,@RequestBody User user,@RequestParam Optional<Long> teamId){
        return userService.updateUserDetails(userId,user,teamId);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long userId){
         userService.deleteUser(userId);
         return;
    }

}
