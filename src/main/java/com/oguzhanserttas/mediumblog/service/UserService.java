package com.oguzhanserttas.mediumblog.service;

import com.oguzhanserttas.mediumblog.model.User;

import java.util.List;

public interface UserService {
    User save(User user);
    List<User> getAll();
    User getById(long id);
    User update(User user, long id);
    void deleteUser(long id);
}
