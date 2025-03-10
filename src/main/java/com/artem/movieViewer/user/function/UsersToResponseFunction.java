package com.artem.movieViewer.user.function;

import com.artem.movieViewer.user.dto.GetUsersResponse;
import com.artem.movieViewer.user.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


@Component
public class UsersToResponseFunction implements Function<List<User>, GetUsersResponse> {

    @Override
    public GetUsersResponse apply(List<User> users) {
        return GetUsersResponse.builder()
                .users(users.stream()
                        .map(user -> GetUsersResponse.User.builder()
                                .id(user.getId())
                                .email(user.getEmail())
                                .name(user.getName())
                                .role(user.getRole())
                                .build()
                        )
                        .collect(Collectors.toList())
                )
                .build();
    }

}
