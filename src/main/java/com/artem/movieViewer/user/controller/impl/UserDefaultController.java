package com.artem.movieViewer.user.controller.impl;

import com.artem.movieViewer.exception.CustomResponseStatusException;
import com.artem.movieViewer.security.JwtUtil;
import com.artem.movieViewer.user.controller.api.UserController;
import com.artem.movieViewer.user.dto.*;
import com.artem.movieViewer.user.function.RequestToUserFunction;
import com.artem.movieViewer.user.function.UsersToResponseFunction;
import com.artem.movieViewer.user.service.api.UserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Log
public class UserDefaultController implements UserController {

    private final UserService userService;
    private final UsersToResponseFunction usersToResponseFunction;
    private final RequestToUserFunction requestToUser;
    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public UserDefaultController(
            UserService userService,
            UsersToResponseFunction usersToResponseFunction, UsersToResponseFunction usersToResponseFunction1,
            RequestToUserFunction requestToUser,
            JwtUtil jwtUtil,
            UserDetailsService userDetailsService,
            AuthenticationManager authenticationManager
    ) {
        this.userService = userService;
        this.usersToResponseFunction = usersToResponseFunction;
        this.requestToUser = requestToUser;
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public GetUsersResponse getUsers() {
        return usersToResponseFunction.apply(userService.findAll());
    }

    @Override
    public UserProfileResponse getUser() {
        var user = userService.getCurrentUser().orElseThrow();
        return UserProfileResponse.builder()
                .email(user.getEmail())
                .name(user.getName())
                .role(user.getRole())
                .build();
    }

    @Override
    public void signUp(PostUserRequest request) {
        userService.create(requestToUser.apply(request));
    }

    @Override
    public UserProfileResponse updateUser(PutUserRequest request) {
        if (userService.findByEmail(request.getEmail()).isPresent()) {
            throw new CustomResponseStatusException(HttpStatus.BAD_REQUEST, "invalidUniqueKey", "Email already exists");
        }
        var user = userService.getCurrentUser().orElseThrow();
        var updatedUser = requestToUser.apply(user.getId(), request);
        userService.create(updatedUser);
        return UserProfileResponse.builder()
                .email(updatedUser.getEmail())
                .name(updatedUser.getName())
                .role(updatedUser.getRole())
                .build();
    }

    @Override
    public void updatePassword(PutPasswordRequest request) {
        var user = userService.getCurrentUser().orElseThrow();
        user.setPassHash(request.getPassword());
        userService.create(user);
    }

    @Override
    public SignInResponse signIn(SignInRequest request) {
        try {
            var user = userService.findByEmail(request.getEmail()).orElseThrow();
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), request.getPassword())
            );
            final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
            final String jwt = jwtUtil.generateToken(userDetails.getUsername());

            return SignInResponse.builder().token(jwt).build();
        } catch (Exception e) {
            throw new CustomResponseStatusException(HttpStatus.BAD_REQUEST, "userNotFound", "User is not found");
        }
    }

    @Override
    public void logout() {
        // TODO: (?) jwt is stateless
    }

}
