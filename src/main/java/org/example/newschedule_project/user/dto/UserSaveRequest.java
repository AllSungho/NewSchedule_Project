package org.example.newschedule_project.user.dto;

import lombok.Getter;

@Getter
public class UserSaveRequest {

    private String name;
    private String email;
    private String password;
}
