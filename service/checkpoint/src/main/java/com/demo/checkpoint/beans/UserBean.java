package com.demo.checkpoint.beans;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserBean {
    long id;
    String firstName;
    String lastName;
    String emailAddress;
    String password;
}
