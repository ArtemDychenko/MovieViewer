package com.artem.movieViewer.movie.service.api;

import com.artem.movieViewer.movie.entity.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    Optional<Movie> findById(int id);

    Optional<Movie> findByName(String name);

    int create(Movie movie);

    List<Movie> findAll();

    int update(Movie movie);

    void delete(int id);

    Optional<List<Movie>> findAllByDirector(int directorId);

}
