package com.artem.movieViewer.controller;

import com.artem.movieViewer.Director;
import com.artem.movieViewer.Movie;
import com.artem.movieViewer.MovieDTO;
import com.artem.movieViewer.service.MovieService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<MovieDTO> getAllMovies() {
        return movieService.getAllMovies().stream()
                .map(MovieDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/genre/{genre}")
    public List<MovieDTO> getMoviesByGenre(@PathVariable String genre) {
        return movieService.getMoviesByGenre(genre).stream()
                .map(MovieDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    @GetMapping("/director/{director}")
    public List<MovieDTO> getMoviesByDirector(@PathVariable String director) {
        return movieService.getAllMovies().stream()
                .filter(Movie -> Movie.getDirector().getName().equalsIgnoreCase(director))
                .map(MovieDTO::new)
                .collect(Collectors.toList());
    }

    @PostMapping
    public MovieDTO createMovie(@RequestBody MovieDTO movieDTO) {
        Movie movie = new Movie.Builder(movieDTO.getName(), movieDTO.getDate_of_release())
                .time(movieDTO.getTime())
                .genre(movieDTO.getGenre())
                .setDirector(new Director(movieDTO.getDirector(), 77777))
                .build();
        Movie savedMovie = movieService.saveMovie(movie);
        return new MovieDTO(savedMovie);
    }
}