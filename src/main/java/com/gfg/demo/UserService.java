package com.gfg.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void createUser(User user) throws SQLException {
        userRepository.saveUser(user);
    }

    public User getUser(int id) throws SQLException {
        return userRepository.getUser(id);
    }

    public List<User> getUsers() throws SQLException {
        return null;
    }
}
