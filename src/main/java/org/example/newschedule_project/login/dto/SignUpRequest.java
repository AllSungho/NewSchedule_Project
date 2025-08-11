package org.example.newschedule_project.login.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SignUpRequest {

    private String name;
    private String email;
    private String password;
}
