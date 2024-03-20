package com.demo.checkpoint.clr;

import com.demo.checkpoint.model.User;
import com.demo.checkpoint.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(1)
public class Init implements CommandLineRunner {

    @Autowired
    private UserServiceImpl userService;

    @Override
    public void run(String... args) throws Exception {

        User u1 = User.builder()
                .firstName("Michal")
                .lastName("Rosen")
                .emailAddress("michal@gmail.com")
                .password("123")
                .build();

        User u2 = User.builder()
                .firstName("Gal")
                .lastName("Golin")
                .emailAddress("gal888@gmail.com")
                .password("123")
                .build();

        User u3 = User.builder()
                .firstName("Ron")
                .lastName("Rabi")
                .emailAddress("ron456@gmail.com")
                .password("123")
                .build();


        userService.addUser(u1);
        userService.addUser(u2);
        userService.addUser(u3);

        List<User> users = userService.getAll();
        users.forEach(System.out::println);

    }
}
