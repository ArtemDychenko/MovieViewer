package com.artem.movieViewer.user.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class SignInResponse {
    private String token;
}
