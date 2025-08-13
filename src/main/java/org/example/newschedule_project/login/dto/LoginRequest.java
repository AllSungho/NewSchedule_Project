package org.example.newschedule_project.login.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

@Getter
public class LoginRequest {

    @Email(message = "이메일 형식으로 요청 바람.")
    private String email;

    @NotEmpty(message = "비밀번호는 필수.")
    private String password;
}
