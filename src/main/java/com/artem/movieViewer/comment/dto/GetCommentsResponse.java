package com.artem.movieViewer.comment.dto;

import com.artem.movieViewer.director.dto.GetDirectorsResponse;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class GetCommentsResponse {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @Builder
    public static class Comment {
        private int id;
        private String content;
    }

    private List<GetCommentsResponse.Comment> comments;
}
