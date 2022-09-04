package com.reviewed.authentication.service;

import com.reviewed.authentication.model.User;

import java.util.Optional;


public interface UserService {

    /**
     * Service method to fetch user by email id
     *
     * @param email
     * @return Optional<User>
     */
    public Optional<User> fetchUserByEmailId(String email);

    /**
     * Service method to check whether a record exists with the given username
     *
     * @param username
     * @return Boolean
     */
    public Boolean existsByUserName(String username);

    /**
     * Service method to save a new user
     *
     * @param user
     * @return User
     */
    public User saveUser(User user);
}
