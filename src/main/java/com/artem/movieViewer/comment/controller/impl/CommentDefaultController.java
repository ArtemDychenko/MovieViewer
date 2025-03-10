package com.artem.movieViewer.comment.controller.impl;

import com.artem.movieViewer.comment.controller.api.CommentController;
import com.artem.movieViewer.comment.dto.GetCommentResponse;
import com.artem.movieViewer.comment.dto.GetCommentsResponse;
import com.artem.movieViewer.comment.dto.PostCommentRequest;
import com.artem.movieViewer.comment.dto.PutCommentRequest;
import com.artem.movieViewer.comment.function.CommentToResponseFunction;
import com.artem.movieViewer.comment.function.CommentsToResponseFunction;
import com.artem.movieViewer.comment.function.RequestToCommentFunction;
import com.artem.movieViewer.comment.service.api.CommentService;
import com.artem.movieViewer.exception.CustomResponseStatusException;
import com.artem.movieViewer.movie.dto.PutMovieRequest;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@Log
public class CommentDefaultController implements CommentController {

    private final CommentsToResponseFunction commentsToResponse;

    private final CommentToResponseFunction commentToResponse;

    private final RequestToCommentFunction requestToComment;

    private final CommentService commentService;

    public CommentDefaultController(CommentsToResponseFunction commentsToResponse, CommentToResponseFunction commentToResponse, RequestToCommentFunction requestToComment, CommentService commentService) {
        this.commentsToResponse = commentsToResponse;
        this.commentToResponse = commentToResponse;
        this.requestToComment = requestToComment;
        this.commentService = commentService;
    }


    @Override
    public GetCommentsResponse getComments() {
        return commentsToResponse.apply(commentService.findAll());
    }


    @Override
    public GetCommentResponse getComment(int id) {
        return commentService.findById(id)
                .map(commentToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public Map<String, Integer> postComment(PostCommentRequest request) {
        int newCommentId = commentService.create(requestToComment.apply(request));
        return Map.of("id", newCommentId);
    }

    @Override
    public Map<String, Integer> putComment(int id, PutCommentRequest request) {
        int newCommentId = commentService.update(requestToComment.apply(id, request));
        return Map.of("id", newCommentId);
    }


    @Override
    public void deleteComment(@PathVariable int id) {
        commentService.findById(id)
                .ifPresentOrElse(
                        director -> commentService.delete(id),
                        () -> {
                            throw new CustomResponseStatusException(HttpStatus.BAD_REQUEST, "routeNotFound", "Route not found");
                        }
                );

    }
}


