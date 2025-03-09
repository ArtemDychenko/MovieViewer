package com.artem.movieViewer.movie.service.api;

import com.artem.movieViewer.movie.entity.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    Optional<Movie> findMovieById(int id);

    Optional<Movie> findMovieByName(String name);

//    int create(Movie movie);

    List<Movie> findAll();

    void updateMovie(Movie movie);

    void deleteMovie(int id);

    Optional<List<Movie>> findAllByDirector(int directorId);

}
