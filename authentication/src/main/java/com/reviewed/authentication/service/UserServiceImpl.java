package com.reviewed.authentication.service;

import com.reviewed.authentication.model.User;
import com.reviewed.authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Base64;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    /**
     *  Service method to fetch user by email id
     *
     * @param email
     * @return Optional<User>
     */
    @Override
    public Optional<User> fetchUserByEmailId(String email) {
         return userRepository.findByEmailId(email);
    }

    /**
     * Service method to check whether a record exists with the given username
     *
     * @param username
     * @return Boolean
     */
    @Override
    public Boolean existsByUserName(String username) {
        return userRepository.existsByUsername(username);
    }

    /**
     * Service method to save a new user
     *
     * @param user
     * @return User
     */
    @Override
    public User saveUser(User user) {
        user.setCreatedOn(Instant.now().getEpochSecond());
        user.setPassword(Base64.getEncoder().encodeToString(user.getPassword().getBytes()));
        return userRepository.save(user);
    }
}
