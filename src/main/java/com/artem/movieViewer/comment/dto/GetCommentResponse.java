package com.artem.movieViewer.comment.dto;

import com.artem.movieViewer.movie.entity.Movie;
import com.artem.movieViewer.user.entity.User;
import com.artem.movieViewer.user.entity.UserRole;
import jakarta.persistence.Column;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class GetCommentResponse {
    private int id;
    private String content;

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Movie {
        private int id;

        private String name;

        private int date_of_release;

        private int time;

        private String genre;
    }

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

    private Movie movie;
    private User user;
}
