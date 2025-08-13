package org.example.newschedule_project.login.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class SignUpRequest {

    @NotNull(message = "이름은 필수.")
    private String name;

    @Email(message = "이메일 형식으로 요청 바람.")
    private String email;

    @NotEmpty(message = "비밀번호는 필수.")
    @Size(min = 5, message = "비밀번호 5자리 이상.")
    private String password;
}
