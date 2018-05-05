package com.cinema.service;

import com.cinema.model.User;

public interface UserService {
    User getUser(Long id);
    Long updateUser(User user);
    Long addUser(User user);
    void deleteUser(Long id);
}
