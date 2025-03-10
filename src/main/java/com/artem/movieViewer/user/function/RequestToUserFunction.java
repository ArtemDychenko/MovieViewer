package com.artem.movieViewer.user.function;

import com.artem.movieViewer.user.dto.PostUserRequest;
import com.artem.movieViewer.user.dto.PutUserRequest;
import com.artem.movieViewer.user.entity.User;
import com.artem.movieViewer.user.entity.UserRole;
import com.artem.movieViewer.user.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RequestToUserFunction implements Function<PostUserRequest, User> {
    private final UserService userService;

    @Autowired
    public RequestToUserFunction(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User apply(PostUserRequest postUserRequest) {
        return User.builder()
                .email(postUserRequest.getEmail())
                .passHash(postUserRequest.getPassword())
                .role(UserRole.USER)
                .build();
    }

    public User apply(int id, PutUserRequest request) {
        var user = userService.findById(id).orElseThrow();
        return User.builder()
                .id(id)
                .username(user.getUsername())
                .name(request.getName())
                .email(request.getEmail())
                .passHash(user.getPassHash())
                .role(user.getRole())
                .build();
    }

}
