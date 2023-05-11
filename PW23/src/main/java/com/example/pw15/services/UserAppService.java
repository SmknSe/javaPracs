package com.example.pw15.services;

import com.example.pw15.entities.User;
import com.example.pw15.entities.UserApp;
import com.example.pw15.repos.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserAppService implements UserDetailsService {
    @Autowired
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserApp userApp = new UserApp(userRepo.findUserByUserName(username));
        if (userApp.getUser() == null) {
            throw new UsernameNotFoundException("username " + username + " doesn't exist");
        }
        return userApp;
    }

    public String signUpUser(User user) {
        boolean exist = userRepo.findUserByUserName(user.getUserName()) != null;
        if (exist) {
            throw new IllegalStateException("already exists");
        }
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        userRepo.save(user);
        return "login";
    }

    public List<User> getUsers(){
        return userRepo.findAll();
    }
}
