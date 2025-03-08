package com.artem.movieViewer.movie.service.api;

import com.artem.movieViewer.movie.entity.Movie;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MovieService {

    Optional<Movie> findMovieById(UUID id);

    Optional<Movie> findMovieByName(String name);

    void createMovie(Movie movie);

    List<Movie> getAllMovies();

    void updateMovie(Movie movie);

    void deleteMovie(UUID id);

    Optional<List<Movie>> findAllByDirector(UUID directorId);

}
