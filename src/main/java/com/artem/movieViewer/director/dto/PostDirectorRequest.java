package com.artem.movieViewer.director.dto;

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
public class PostDirectorRequest {
    @NotNull
    String name;
    @NotNull
    int year_of_birth;
    @NotEmpty
    private List<@NotNull Integer> movies;
}
