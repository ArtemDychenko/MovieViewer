package com.artem.movieViewer.user.dto;

import com.artem.movieViewer.user.entity.UserRole;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class UserProfileResponse {
    private String email;
    private String name;
    private UserRole role;
}
