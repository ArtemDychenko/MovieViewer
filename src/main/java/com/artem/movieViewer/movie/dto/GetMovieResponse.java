package com.artem.movieViewer.movie.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetMovieResponse {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Director {
        private int id;

        private String name;

        private int yearOfBirth;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Comment {
        private int id;

        private String content;

    }

    private int id;

    private String name;

    private int date_of_release;

    private int time;

    private String genre;

    private Director director;

    private List<Comment> comments;
}