package com.example.pw15.repos;

import com.example.pw15.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    public User findUserByUserName(String username);
}
