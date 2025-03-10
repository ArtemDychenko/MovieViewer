package com.artem.movieViewer.movie.controller.impl;

import com.artem.movieViewer.exception.CustomResponseStatusException;
import com.artem.movieViewer.movie.controller.api.MovieController;
import com.artem.movieViewer.movie.dto.GetMovieResponse;
import com.artem.movieViewer.movie.dto.GetMoviesResponse;
import com.artem.movieViewer.movie.dto.PostMovieRequest;
import com.artem.movieViewer.movie.dto.PutMovieRequest;
import com.artem.movieViewer.movie.function.MovieToResponseFunction;
import com.artem.movieViewer.movie.function.MoviesToResponseFunction;
import com.artem.movieViewer.movie.function.RequestToMovieFunction;
import com.artem.movieViewer.movie.service.impl.MovieDefaultService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@Log
public class MovieDefaultController implements MovieController {

    private final MovieDefaultService movieService;

    private final MoviesToResponseFunction moviesToResponse;

    private final MovieToResponseFunction movieToResponse;

    private final RequestToMovieFunction requestToMovie;

    private final String directorServiceUrl = "http://localhost:8082/api/director";


    @Autowired
    public MovieDefaultController(MovieDefaultService movieService, MoviesToResponseFunction moviesToResponse, MovieToResponseFunction movieToResponse, RequestToMovieFunction requestToMovie) {
        this.movieService = movieService;
        this.moviesToResponse = moviesToResponse;
        this.movieToResponse = movieToResponse;

        this.requestToMovie = requestToMovie;
    }

    @Override
    public GetMoviesResponse getMovies() {
        return moviesToResponse.apply(movieService.findAll());
    }

    @Override
    public GetMovieResponse getMovie(int id) {
        return movieService.findById(id)
                .map(movieToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public Map<String, Integer> postMovie(PostMovieRequest request) {
        int newMovieId = movieService.create(requestToMovie.apply(request));
        return Map.of("id", newMovieId);
    }

    @Override
    public Map<String, Integer> putMovie(int id, PutMovieRequest request) {
        int newMovieId = movieService.update(requestToMovie.apply(id, request));
        return Map.of("id", newMovieId);
    }

    @Override
    public void deleteMovie(@PathVariable int id) {
        movieService.findById(id)
                .ifPresentOrElse(
                        Movie -> movieService.delete(id),
                        () -> {
                            throw new CustomResponseStatusException(HttpStatus.BAD_REQUEST, "routeNotFound", "Route not found");
                        }
                );

    }
}