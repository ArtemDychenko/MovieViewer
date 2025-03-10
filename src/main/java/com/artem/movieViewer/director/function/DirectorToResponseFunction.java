package com.artem.movieViewer.director.function;


import com.artem.movieViewer.director.dto.GetDirectorResponse;
import com.artem.movieViewer.director.entity.Director;
import org.springframework.stereotype.Component;

import java.util.function.Function;


@Component
public class DirectorToResponseFunction implements Function<Director, GetDirectorResponse> {

    @Override
    public GetDirectorResponse apply(Director entity) {
        return GetDirectorResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .yearOfBirth(entity.getYearOfBirth())
                .movies(entity.getMovies().stream()
                        .map(movie -> GetDirectorResponse.Movie.builder()
                                .id(movie.getId())
                                .name(movie.getName())
                                .date_of_release(movie.getDate_of_release())
                                .time(movie.getTime())
                                .genre(movie.getGenre())
                                .build())
                        .toList())
                .build();

    }

}
