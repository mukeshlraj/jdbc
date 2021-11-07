package com.gfg.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public User getUser(@RequestParam("id") int id) throws SQLException {
        return userService.getUser(id);
    }

    @GetMapping("/users")
    public List<User> getUsers() throws SQLException {
        return userService.getUsers();
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User user) throws SQLException {
        userService.createUser(user);
    }
}
