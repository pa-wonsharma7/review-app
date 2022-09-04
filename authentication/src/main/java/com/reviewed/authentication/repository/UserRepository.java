package com.reviewed.authentication.repository;

import com.reviewed.authentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    public Optional<User> findByEmailId(String emailId);

    public Boolean existsByUsername(String username);
}
