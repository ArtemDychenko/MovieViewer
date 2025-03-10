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
public class GetMoviesResponse {

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

    @Singular
    private List<Movie> movies;

}
