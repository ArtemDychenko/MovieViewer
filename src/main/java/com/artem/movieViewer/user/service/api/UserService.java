package com.artem.movieViewer.user.service.api;


import com.artem.movieViewer.user.entity.User;

import java.util.List;
import java.util.Optional;


public interface UserService {
    List<User> findAll();

    Optional<User> findById(int id);

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    Optional<User> getCurrentUser();

    void create(User user);

    void delete(int id);

}
