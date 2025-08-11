package org.example.newschedule_project.user.userdto;

import lombok.Getter;
import org.example.newschedule_project.user.entity.User;

import java.time.LocalDateTime;

@Getter
public class UserResponse {

    private final Long id;
    private final String name;
    private final String email;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public UserResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.createdAt = user.getCreatedAt();
        this.modifiedAt = user.getModifiedAt();
    }
}
