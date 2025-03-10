package com.artem.movieViewer.comment.service.api;

import com.artem.movieViewer.comment.entity.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {

    Optional<Comment> findById(int id);

    int create(Comment movie);

    List<Comment> findAll();

    int update(Comment movie);

    void delete(int id);

}
