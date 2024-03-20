package com.demo.checkpoint.services;

import com.demo.checkpoint.beans.UserBean;
import com.demo.checkpoint.converters.UserConverter;
import com.demo.checkpoint.model.User;
import com.demo.checkpoint.repositories.UserRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.demo.checkpoint.converters.UserConverter.toBean;
import static com.demo.checkpoint.converters.UserConverter.toDto;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Retryable(value = {DataAccessException.class}, maxAttempts = 2, backoff = @Backoff(delay = 1000))
    public List<UserBean> getAll() {
        return userRepository.findAll().stream().map(UserConverter::toBean).toList();
    }

    @Override
    @Retryable(value = {DataAccessException.class}, maxAttempts = 2, backoff = @Backoff(delay = 1000))
    public UserBean addUser(@Valid UserBean user) {
        //TODO: add validations
        User newUser = userRepository.save(toDto(user));
        return toBean(newUser);
    }

    @Override
    @Retryable(value = {DataAccessException.class}, maxAttempts = 2, backoff = @Backoff(delay = 1000))
    public void deleteUser(int id) {
        // TODO: add validation
        userRepository.deleteById(id);
    }

}
