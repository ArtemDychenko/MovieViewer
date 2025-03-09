package com.artem.movieViewer.movie.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PostMovieRequest {
    @NotNull
    String name;
    @NotNull
    int date_of_release;
    @NotNull
    int time;
    @NotNull
    String genre;
    @NotNull
    int directorId;
}
