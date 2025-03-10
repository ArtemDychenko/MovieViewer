package com.artem.movieViewer.comment.function;

import com.artem.movieViewer.comment.dto.PostCommentRequest;
import com.artem.movieViewer.comment.dto.PutCommentRequest;
import com.artem.movieViewer.comment.entity.Comment;
import com.artem.movieViewer.movie.entity.Movie;
import com.artem.movieViewer.user.entity.User;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RequestToCommentFunction implements Function<PostCommentRequest, Comment> {

    @Override
    public Comment apply(PostCommentRequest postCommentRequest) {
        return Comment.builder()
                .content(postCommentRequest.getContent())
                .movie(Movie.builder()
                        .id(postCommentRequest.getMovieId())
                        .build())
                .user(User.builder()
                        .id(postCommentRequest.getUserId())
                        .build())
                .build();
    }


    public Comment apply(int id, PutCommentRequest putCommentRequest) {
        return Comment.builder()
                .id(id)
                .content(putCommentRequest.getContent())
                .movie(Movie.builder()
                        .id(putCommentRequest.getMovieId())
                        .build())
                .user(User.builder()
                        .id(putCommentRequest.getUserId())
                        .build())
                .build();
    }
}
