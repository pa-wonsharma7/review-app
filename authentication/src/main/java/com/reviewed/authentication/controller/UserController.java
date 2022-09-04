package com.reviewed.authentication.controller;

import com.reviewed.authentication.model.User;
import com.reviewed.authentication.repository.UserRepository;
import com.reviewed.authentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    /**
     * API to register a new User
     * @param user
     * @return ResponseEntity<User>
     */
    @PostMapping("/register-user")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        Assert.notNull(user,"Request Body is Empty");
        if(user.getEmailId() !=null && !"".equals(user.getEmailId())){
            Optional<User> userobj = userService.fetchUserByEmailId(user.getEmailId());
            if(userobj.isPresent())
                throw new RuntimeException("User with " + user.getEmailId() + "already exists");
        }
        if(user.getUsername() !=null && !"".equals(user.getUsername())){
            if(userService.existsByUserName(user.getUsername()))
                throw new RuntimeException("Username " + user.getUsername() + "already exists. Try a different one.");
        }
        User userObj=null;
        userObj= userService.saveUser(user);
        return new ResponseEntity<>(userObj, HttpStatus.CREATED);
    }
}
