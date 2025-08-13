package org.example.newschedule_project.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class UserUpdateReqeust {

    @NotNull(message = "이름을 입력하시오.")
    private String name;
    @Email(message = "이메일 형식으로 입력하시오.")
    private String email;
    @NotNull(message = "비밀번호를 입력하시오.")
    private String password;
}
