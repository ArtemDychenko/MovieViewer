package com.artem.movieViewer.user.entity;

import com.artem.movieViewer.comment.entity.Comment;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Builder.Default
    String username = String.valueOf(UUID.randomUUID());

    String email;
    String name;

    @Enumerated(EnumType.STRING)
    UserRole role;

    @ToString.Exclude
    String passHash;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    List<Comment> comments = new ArrayList<>();
}
