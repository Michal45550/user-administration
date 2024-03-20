package com.demo.checkpoint.services;

import com.demo.checkpoint.model.User;
import com.demo.checkpoint.repositories.UserRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    //private final UserValidator userValidator;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(@Valid User user) {
        //userValidator.validate(user);

        return userRepository.save(user);
    }

}
