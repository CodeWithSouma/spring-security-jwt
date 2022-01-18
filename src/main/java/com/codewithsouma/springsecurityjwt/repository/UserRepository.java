package com.codewithsouma.springsecurityjwt.repository;


import com.codewithsouma.springsecurityjwt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String username);
}
