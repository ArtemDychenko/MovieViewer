package com.artem.movieViewer.director.function;

import com.artem.movieViewer.director.dto.PostDirectorRequest;
import com.artem.movieViewer.director.dto.PutDirectorRequest;
import com.artem.movieViewer.director.entity.Director;
import com.artem.movieViewer.movie.dto.PostMovieRequest;
import com.artem.movieViewer.movie.dto.PutMovieRequest;
import com.artem.movieViewer.movie.entity.Movie;
import com.artem.movieViewer.movie.service.api.MovieService;

import java.util.function.Function;

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
                        .map((id) -> movieService.findMovieById(id).orElseThrow())
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
                        .map((movieId) -> movieService.findMovieById(movieId).orElseThrow())
                        .toList()
                )
                .build();
    }
}
