package com.artem.movieViewer.comment.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PostCommentRequest {
    @NotNull
    String content;
    @NotNull
    int userId;
    @NotNull
    int movieId;
}
