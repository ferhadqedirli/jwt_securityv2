package com.workshop.bouali.service;

import com.workshop.bouali.domain.Role;
import com.workshop.bouali.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String userName);
    List<User> getUsers();
}
