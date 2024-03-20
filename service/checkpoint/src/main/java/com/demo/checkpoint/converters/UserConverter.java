package com.demo.checkpoint.converters;

import com.demo.checkpoint.beans.UserBean;
import com.demo.checkpoint.model.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserConverter {

    public static UserBean toBean(User user) {
        return UserBean.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .emailAddress(user.getEmailAddress())
                .password(user.getPassword())
                .build();
    }

    public static User toDto(UserBean user) {
        return User.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .emailAddress(user.getEmailAddress())
                .password(user.getPassword())
                .build();
    }

}
