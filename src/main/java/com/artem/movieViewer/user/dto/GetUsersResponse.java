package com.artem.movieViewer.user.dto;

import com.artem.movieViewer.user.entity.UserRole;
import lombok.*;

import java.util.List;

/**
 * GET users response. Contains names and ids of users in the system. User's name is the same as login.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetUsersResponse {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class User {
        private int id;
        private String email;
        private String name;
        private UserRole role;
    }


    private List<User> users;

}
