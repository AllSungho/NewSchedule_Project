package org.example.newschedule_project.user.userdto;

import lombok.Getter;

@Getter
public class UserSaveRequest {

    private String name;
    private String email;
    private String password;
}
