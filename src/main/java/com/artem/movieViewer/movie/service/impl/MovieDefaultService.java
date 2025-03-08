package com.artem.movieViewer.movie.service.impl;


import com.artem.movieViewer.movie.entity.Director;
import com.artem.movieViewer.movie.entity.Movie;
import com.artem.movieViewer.movie.repository.api.DirectorRepository;
import com.artem.movieViewer.movie.repository.api.MovieRepository;
import com.artem.movieViewer.movie.service.api.DirectorService;
import com.artem.movieViewer.movie.service.api.MovieService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public void createMovie(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public void updateMovie(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public Optional<Movie> findMovieById(UUID id) {
        return movieRepository.findById(id);
    }

    @Override
    public Optional<Movie> findMovieByName(String name) {
        return movieRepository.findByName(name);
    }

    @Override
    public void deleteMovie(UUID id) {
        movieRepository.deleteById(id);
    }

    @Override
    public Optional<List<Movie>> findAllByDirector(UUID directorId) {
        return directorRepository.findById(directorId)
                .map(movieRepository::findAllByDirector);
    }

}
