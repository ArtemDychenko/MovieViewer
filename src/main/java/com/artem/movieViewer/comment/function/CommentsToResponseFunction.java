package com.artem.movieViewer.comment.function;

import com.artem.movieViewer.comment.dto.GetCommentResponse;
import com.artem.movieViewer.comment.dto.GetCommentsResponse;
import com.artem.movieViewer.comment.entity.Comment;
import com.artem.movieViewer.movie.dto.GetMoviesResponse;
import com.artem.movieViewer.movie.entity.Movie;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class CommentsToResponseFunction implements Function<List<Comment>, GetCommentsResponse> {

    @Override
    public GetCommentsResponse apply(List<Comment> entities) {
        return GetCommentsResponse.builder()
                .comments(entities.stream()
                        .map(comment -> GetCommentsResponse.Comment.builder()
                                .id(comment.getId())
                                .content(comment.getContent())
                                .build())
                        .toList())
                .build();
    }
}
