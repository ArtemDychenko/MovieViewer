//package com.artem.movieViewer.comment.function;
//
//import com.artem.movieViewer.comment.entity.Comment;
//import org.springframework.stereotype.Component;
//
//import java.util.function.Function;
//
//@Component
//public class CommentToResponseFunction implements Function<Comment, GetCommentResponse> {
//    @Override
//    public GetCommentResponse apply(Comment entity) {
//        return GetCommentResponse.builder()
//                .id(entity.getId())
//                .content(entity.getContent())
//                .movie(GetCommentResponse.Movie.builder()
//                        .id(entity.getMovie().getId())
//                        .name(entity.getMovie().getName())
//                        .date_of_release(entity.getMovie().getDate_of_release())
//                        .time(entity.getMovie().getTime())
//                        .genre(entity.getMovie().getGenre())
//                        .build())
//                .user(GetCommentResponse.User.builder()
//                        .id(entity.getUser().getId())
//                        .name(entity.getUser().getName())
//                        .email(entity.getUser().getEmail())
//                        .role(entity.getUser().getRole())
//                        .build())
//                .build();
//
//    }
//}
