package com.demo.checkpoint.controllers;

import com.demo.checkpoint.beans.UserBean;
import com.demo.checkpoint.services.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static com.demo.checkpoint.mockData.UserDataProvider.getUsersBeanList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class UserControllerTest {

    @Mock
    private UserServiceImpl userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAll() {
        List<UserBean> users = getUsersBeanList();

        when(userService.getAll()).thenReturn(users);

        ResponseEntity<List<UserBean>> response = userController.getAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(users, response.getBody());

        verify(userService, times(1)).getAll();
    }

    @Test
    void testAddUser() {
        UserBean user = UserBean.builder()
                .id(1)
                .firstName("Michal")
                .lastName("Rosen")
                .emailAddress("michal@gmail.com")
                .password("123")
                .build();

        when(userService.addUser(any())).thenReturn(user);

        ResponseEntity<UserBean> response = userController.addUser(user);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());

        verify(userService, times(1)).addUser(any());
    }


}
