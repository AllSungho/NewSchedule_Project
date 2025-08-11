package org.example.newschedule_project.login.dto;

import lombok.Getter;
import org.example.newschedule_project.user.entity.User;

import java.time.LocalDateTime;

@Getter
public class LoginResponse {

    private final Long id;
    private final String name;
    private final String email;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public LoginResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.createdAt = user.getCreatedAt();
        this.modifiedAt = user.getModifiedAt();
    }
}
