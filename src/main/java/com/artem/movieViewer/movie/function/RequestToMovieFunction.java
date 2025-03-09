package com.artem.movieViewer.movie.function;

import com.artem.movieViewer.director.entity.Director;
import com.artem.movieViewer.director.service.api.DirectorService;
import com.artem.movieViewer.movie.dto.PostMovieRequest;
import com.artem.movieViewer.movie.dto.PutMovieRequest;
import com.artem.movieViewer.movie.entity.Movie;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Function;

@Component
public class RequestToMovieFunction implements Function<PostMovieRequest, Movie> {

    @Override
    public Movie apply(PostMovieRequest postMovieRequest) {
        return Movie.builder()
                .name(postMovieRequest.getName())
                .time(postMovieRequest.getTime())
                .genre(postMovieRequest.getGenre())
                .director(Director.builder()
                        .id(postMovieRequest.getDirectorId())
                        .build())
                .build();
    }


    public Movie apply(int id, PutMovieRequest putMovieRequest) {
        return Movie.builder()
                .id(id)
                .name(putMovieRequest.getName())
                .time(putMovieRequest.getTime())
                .genre(putMovieRequest.getGenre())
                .director(Director.builder()
                        .id(putMovieRequest.getDirectorId())
                        .build())
                .build();
    }
}
