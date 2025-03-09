package com.artem.movieViewer.movie.controller.api;


import com.artem.movieViewer.movie.dto.GetMovieResponse;
import com.artem.movieViewer.movie.dto.GetMoviesResponse;
import com.artem.movieViewer.movie.dto.PostMovieRequest;
import com.artem.movieViewer.movie.dto.PutMovieRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

public interface MovieController {

    @GetMapping("api/movie")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetMoviesResponse getMovies();


    @GetMapping("/api/movie/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetMovieResponse getMovie(
            @PathVariable("id")
            int id
    );

    @PostMapping("/api/movie")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    Map<String, Integer> postMovie(@RequestBody @Valid PostMovieRequest request);

    @PutMapping("/api/movie/{id")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    Map<String, Integer> putMovie(@PathVariable int id, @RequestBody @Valid PutMovieRequest request);

    @DeleteMapping("/api/movie/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteMovie(
            @PathVariable("id")
            int id
    );
}