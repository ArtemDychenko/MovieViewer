package com.artem.movieViewer.movie.service.impl;


import com.artem.movieViewer.director.repository.api.DirectorRepository;
import com.artem.movieViewer.movie.entity.Movie;
import com.artem.movieViewer.movie.repository.api.MovieRepository;
import com.artem.movieViewer.movie.service.api.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieDefaultService implements MovieService {
    private final MovieRepository movieRepository;
    private final DirectorRepository directorRepository;


    private final String directorServiceUrl = "http://localhost:8082/api/directors";

    @Autowired
    public MovieDefaultService(MovieRepository movieRepository, DirectorRepository directorRepository) {
        this.movieRepository = movieRepository;
        this.directorRepository = directorRepository;


    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public int create(Movie movie) {
        var newMovie = this.movieRepository.save(movie);
        return newMovie.getId();
    }

    @Override
    public int update(Movie movie) {
        return this.create(movie);
    }

    public Optional<Movie> findMovieById(int id) {
        return movieRepository.findById(id);
    }

    @Override
    public Optional<Movie> findMovieByName(String name) {
        return movieRepository.findByName(name);
    }

    public void delete(int id) {
        movieRepository.deleteById(id);
    }

    @Override
    public Optional<List<Movie>> findAllByDirector(int directorId) {
        return directorRepository.findById(directorId)
                .map(movieRepository::findAllByDirector);
    }

}
