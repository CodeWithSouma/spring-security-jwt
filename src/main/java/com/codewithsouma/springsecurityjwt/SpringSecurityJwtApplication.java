package com.codewithsouma.springsecurityjwt;

import com.codewithsouma.springsecurityjwt.entity.User;
import com.codewithsouma.springsecurityjwt.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@AllArgsConstructor
public class SpringSecurityJwtApplication {
    private final UserRepository repository;

    @PostConstruct
    public void initUsers() {
        List<User> users = Stream.of(
                new User(101, "javatechie", "javatechie@gmail.com", "password"),
                new User(102, "user1", "user1@gmail.com", "pwd1"),
                new User(103, "user2", "user2@gmail.com", "pwd2"),
                new User(104, "user3", "user3@gmail.com", "pwd3")
        ).collect(Collectors.toList());
        repository.saveAll(users);
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJwtApplication.class, args);
    }

}
