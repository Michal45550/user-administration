package com.demo.checkpoint.controllers;

import com.demo.checkpoint.beans.UserBean;
import com.demo.checkpoint.services.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @GetMapping
    public ResponseEntity<List<UserBean>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @PostMapping
    public ResponseEntity<UserBean> addUser(@Valid @RequestBody UserBean user) {
        return ResponseEntity.ok(userService.addUser(user));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(value = NO_CONTENT)
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

}
