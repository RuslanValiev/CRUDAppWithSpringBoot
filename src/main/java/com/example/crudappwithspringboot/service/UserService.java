package com.example.crudappwithspringboot.service;


import com.example.crudappwithspringboot.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    List<User> findAllUsers();

    public void removeUserById(long id);

    public User findUserById(long id);

    public void updateUser(long id, User user);
}