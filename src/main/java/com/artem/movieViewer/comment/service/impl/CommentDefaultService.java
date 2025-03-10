package com.artem.movieViewer.comment.service.impl;


import com.artem.movieViewer.comment.entity.Comment;
import com.artem.movieViewer.comment.repository.api.CommentRepository;
import com.artem.movieViewer.comment.service.api.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentDefaultService implements CommentService {
    private final CommentRepository commentRepository;

    public CommentDefaultService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public int create(Comment comment) {
        var newComment = this.commentRepository.save(comment);
        return newComment.getId();
    }

    @Override
    public int update(Comment comment) {
        return this.create(comment);
    }

    public Optional<Comment> findById(int id) {
        return commentRepository.findById(id);
    }

    public void delete(int id) {
        commentRepository.deleteById(id);
    }
}
