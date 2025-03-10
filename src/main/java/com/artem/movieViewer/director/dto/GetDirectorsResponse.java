package com.artem.movieViewer.director.dto;

import lombok.*;

import java.util.List;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class GetDirectorsResponse {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @Builder
    public static class Director {
        private int id;
        private String name;
        private String yearOfBirth;
    }

    private List<Director> directors;

}