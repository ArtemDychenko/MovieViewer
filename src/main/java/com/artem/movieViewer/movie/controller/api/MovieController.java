package com.artem.movieViewer.movie.controller.api;


import com.artem.movieViewer.movie.dto.GetMovieResponse;
import com.artem.movieViewer.movie.dto.GetMoviesResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

//    @PostMapping("/api/movie")
//    @ResponseStatus(HttpStatus.CREATED)
//    @ResponseBody
//    Map<String, Integer> postMovie(@RequestBody @Valid PostMovieRequest request);

    @DeleteMapping("/api/movie/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteMovie(
            @PathVariable("id")
            int id
    );
}