package com.demo.checkpoint.services;

import com.demo.checkpoint.beans.UserBean;
import com.demo.checkpoint.model.User;
import com.demo.checkpoint.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static com.demo.checkpoint.mockData.UserDataProvider.getUsersList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAll() {

        List<User> Users = getUsersList();

        when(userRepository.findAll()).thenReturn(Users);

        List<UserBean> UserBeans = userService.getAll();

        assertEquals(2, UserBeans.size());
        assertEquals(1L, UserBeans.get(0).getId());
        assertEquals("Michal", UserBeans.get(0).getFirstName());
    }
    
}
