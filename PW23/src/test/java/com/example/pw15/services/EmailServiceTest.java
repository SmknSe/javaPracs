package com.example.pw15.services;

import com.example.pw15.entities.User;
import com.example.pw15.entities.UserApp;
import com.example.pw15.repos.UserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class EmailServiceTest {
    @Mock
    private UserRepo userRepo;
    private UserAppService userAppService;
    @Captor
    ArgumentCaptor<User> captor;

    @BeforeEach
    public void setUp(){
        userAppService = new UserAppService(new BCryptPasswordEncoder(10),userRepo);
    }

    @Test
    void getUsers() {
        User user = new User();
        user.setUserName("Vasya");
        User user2 = new User();
        user2.setUserName("Dima");
        Mockito.when(userRepo.findAll()).thenReturn(List.of(user, user2));
        assertEquals(2, userAppService.getUsers().size());
        assertEquals("Vasya", userAppService.getUsers().get(0).getUserName());
    }

    @Test
    void loadUserByUsername() {
        User user = new User();
        user.setUserName("user");
        user.setPassword("pswd");

        UserApp userApp = new UserApp(user);

        Mockito.when(userRepo.findUserByUserName(userApp.getUsername())).thenReturn(user);

        User expected = userRepo.findUserByUserName(userApp.getUsername());

        assertEquals(expected,user);
    }
}
