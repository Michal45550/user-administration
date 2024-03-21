package com.demo.checkpoint.mockData;

import com.demo.checkpoint.beans.UserBean;
import com.demo.checkpoint.model.User;
import lombok.experimental.UtilityClass;

import java.util.List;

import static java.util.Arrays.asList;

@UtilityClass
public class UserDataProvider {

    public static List<UserBean> getUsersBeanList() {
        return asList(
                UserBean.builder()
                        .id(1)
                        .firstName("Michal")
                        .lastName("Rosen")
                        .emailAddress("michal@gmail.com")
                        .password("123")
                        .build(),
                UserBean.builder()
                        .id(2)
                        .firstName("Gal")
                        .lastName("Golin")
                        .emailAddress("gal888@gmail.com")
                        .password("123")
                        .build()
        );
    }

    public static List<User> getUsersList() {
        return asList(
                User.builder()
                        .id(1)
                        .firstName("Michal")
                        .lastName("Rosen")
                        .emailAddress("michal@gmail.com")
                        .password("123")
                        .build(),
                User.builder()
                        .id(2)
                        .firstName("Gal")
                        .lastName("Golin")
                        .emailAddress("gal888@gmail.com")
                        .password("123")
                        .build()
        );
    }

    public static User getUser() {
        return User.builder()
                .id(1)
                .firstName("Michal")
                .lastName("Rosen")
                .emailAddress("michal@gmail.com")
                .password("123")
                .build();
    }

    public static UserBean getUserBean() {
        return UserBean.builder()
                .id(1)
                .firstName("Michal")
                .lastName("Rosen")
                .emailAddress("michal@gmail.com")
                .password("123")
                .build();
    }

}
