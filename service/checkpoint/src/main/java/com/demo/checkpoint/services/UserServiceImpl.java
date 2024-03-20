package com.demo.checkpoint.services;

import com.demo.checkpoint.beans.UserBean;
import com.demo.checkpoint.converters.UserConverter;
import com.demo.checkpoint.model.User;
import com.demo.checkpoint.repositories.UserRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.demo.checkpoint.converters.UserConverter.toBean;
import static com.demo.checkpoint.converters.UserConverter.toDto;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserBean> getAll() {
        return userRepository.findAll().stream().map(UserConverter::toBean).toList();
    }

    @Override
    public UserBean addUser(@Valid UserBean user) {
        //TODO: add validations
        User newUser = userRepository.save(toDto(user));
        return toBean(newUser);
    }

    @Override
    public void deleteUser(int id) {
        // TODO: add validation
        userRepository.deleteById(id);
    }

}
