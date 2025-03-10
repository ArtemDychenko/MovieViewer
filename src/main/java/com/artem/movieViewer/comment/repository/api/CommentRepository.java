package com.artem.movieViewer.comment.repository.api;

import com.artem.movieViewer.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
