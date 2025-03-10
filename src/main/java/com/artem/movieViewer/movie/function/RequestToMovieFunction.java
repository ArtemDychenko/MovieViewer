package com.artem.movieViewer.movie.function;

import com.artem.movieViewer.comment.service.api.CommentService;
import com.artem.movieViewer.director.entity.Director;
import com.artem.movieViewer.movie.dto.PostMovieRequest;
import com.artem.movieViewer.movie.dto.PutMovieRequest;
import com.artem.movieViewer.movie.entity.Movie;
import com.artem.movieViewer.movie.service.api.MovieService;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class RequestToMovieFunction implements Function<PostMovieRequest, Movie> {

    private final CommentService commentService;

    public RequestToMovieFunction(CommentService commentService) {
        this.commentService = commentService;
    }

    @Override
    public Movie apply(PostMovieRequest postMovieRequest) {
        return Movie.builder()
                .name(postMovieRequest.getName())
                .time(postMovieRequest.getTime())
                .genre(postMovieRequest.getGenre())
                .director(Director.builder()
                        .id(postMovieRequest.getDirector())
                        .build())
                .comments(postMovieRequest.getComments().stream()
                        .map((id) -> commentService.findById(id).orElseThrow())
                        .toList()
                )
                .build();
    }

    public Movie apply(int id, PutMovieRequest putMovieRequest) {
        return Movie.builder()
                .id(id)
                .name(putMovieRequest.getName())
                .time(putMovieRequest.getTime())
                .genre(putMovieRequest.getGenre())
                .director(Director.builder()
                        .id(putMovieRequest.getDirector())
                        .build())
                .comments(putMovieRequest.getComments().stream()
                        .map((commentId) -> commentService.findById(commentId).orElseThrow())
                        .toList()
                )
                .build();
    }
}
