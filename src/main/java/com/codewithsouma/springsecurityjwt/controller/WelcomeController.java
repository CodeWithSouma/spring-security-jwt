package com.codewithsouma.springsecurityjwt.controller;

import com.codewithsouma.springsecurityjwt.entity.AuthRequest;
import com.codewithsouma.springsecurityjwt.util.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WelcomeController {
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String welcome(){
        return "Welcome to our site.";
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest request) throws Exception {
       try{
           authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUserName(),request.getPassword())
        );
       }catch (Exception ex){
           throw new Exception("Invalid username and password");
       }

       return jwtUtil.generateToken(request.getUserName());
    }
}
