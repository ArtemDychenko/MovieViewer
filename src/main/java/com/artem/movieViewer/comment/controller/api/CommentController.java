package com.artem.movieViewer.comment.controller.api;

import com.artem.movieViewer.comment.dto.GetCommentResponse;
import com.artem.movieViewer.comment.dto.GetCommentsResponse;
import com.artem.movieViewer.comment.dto.PostCommentRequest;
import com.artem.movieViewer.comment.dto.PutCommentRequest;
import com.artem.movieViewer.director.dto.GetDirectorResponse;
import com.artem.movieViewer.director.dto.GetDirectorsResponse;
import com.artem.movieViewer.director.dto.PostDirectorRequest;
import com.artem.movieViewer.director.dto.PutDirectorRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

public interface CommentController {

    @GetMapping("api/comment")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetCommentsResponse getComments();


    @GetMapping("/api/comment/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetCommentResponse getComment(
            @PathVariable("id")
            int id
    );

    @PostMapping("api/comment")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    Map<String, Integer> postComment(@RequestBody @Valid PostCommentRequest request);

    @PutMapping("/api/comment/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    Map<String, Integer> putComment(@PathVariable int id, @RequestBody @Valid PutCommentRequest request);

    @DeleteMapping("/api/comment/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteComment(
            @PathVariable("id")
            int id
    );

}
