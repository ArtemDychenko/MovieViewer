package com.artem.movieViewer.movie.entity;

import com.artem.movieViewer.director.entity.Director;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString(callSuper = true)
@EqualsAndHashCode
@Entity
@Table(name = "movies")
public class Movie implements Comparable<Movie>, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "name")
    private String name;

    @Column(name = "date_of_release")
    private int date_of_release;

    @Column(name = "time")
    private int time;

    @Column(name = "genre")
    private String genre;

    @ManyToOne
    @JoinColumn(name = "director_id") // Foreign Key
    public Director director;

    @Override
    public int compareTo(Movie other) {
        return this.name.compareTo((other.name));
    }

}