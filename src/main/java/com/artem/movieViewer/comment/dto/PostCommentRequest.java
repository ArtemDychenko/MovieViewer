package com.artem.movieViewer.comment.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

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
