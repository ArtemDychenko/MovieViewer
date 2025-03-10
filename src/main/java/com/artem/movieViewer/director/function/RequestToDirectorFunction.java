package com.artem.movieViewer.director.function;

import com.artem.movieViewer.director.dto.PostDirectorRequest;
import com.artem.movieViewer.director.dto.PutDirectorRequest;
import com.artem.movieViewer.director.entity.Director;
import com.artem.movieViewer.movie.service.api.MovieService;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RequestToDirectorFunction implements Function<PostDirectorRequest, Director> {

    private final MovieService movieService;

    public RequestToDirectorFunction(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public Director apply(PostDirectorRequest postDirectorRequest) {
        return Director.builder()
                .name(postDirectorRequest.getName())
                .yearOfBirth(postDirectorRequest.getYear_of_birth())
                .movies(postDirectorRequest.getMovies().stream()
                        .map((id) -> movieService.findById(id).orElseThrow())
                        .toList()
                )
                .build();
    }


    public Director apply(int id, PutDirectorRequest putDirectorRequest) {
        return Director.builder()
                .id(id)
                .name(putDirectorRequest.getName())
                .yearOfBirth(putDirectorRequest.getYear_of_birth())
                .movies(putDirectorRequest.getMovies().stream()
                        .map((movieId) -> movieService.findById(movieId).orElseThrow())
                        .toList()
                )
                .build();
    }
}
