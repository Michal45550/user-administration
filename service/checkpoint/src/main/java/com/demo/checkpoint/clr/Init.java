package com.demo.checkpoint.clr;

import com.demo.checkpoint.beans.UserBean;
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
    public void run(String... args) {

        UserBean u1 = UserBean.builder()
                .firstName("Michal")
                .lastName("Rosen")
                .emailAddress("michal@gmail.com")
                .password("123")
                .build();

        UserBean u2 = UserBean.builder()
                .firstName("Gal")
                .lastName("Golin")
                .emailAddress("gal888@gmail.com")
                .password("123")
                .build();

        UserBean u3 = UserBean.builder()
                .firstName("Ron")
                .lastName("Rabi")
                .emailAddress("ron456@gmail.com")
                .password("123")
                .build();


        userService.addUser(u1);
        userService.addUser(u2);
        userService.addUser(u3);

        List<UserBean> users = userService.getAll();
        users.forEach(System.out::println);

    }
}
