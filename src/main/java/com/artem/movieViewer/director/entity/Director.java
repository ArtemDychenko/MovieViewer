package com.artem.movieViewer.director.entity;

import com.artem.movieViewer.movie.entity.Movie;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "directors")
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Director implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "year_of_birth")
    int yearOfBirth;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    @OneToMany(mappedBy = "director", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    List<Movie> movies = new ArrayList<>();


}