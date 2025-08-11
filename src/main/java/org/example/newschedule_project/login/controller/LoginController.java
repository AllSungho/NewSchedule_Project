package org.example.newschedule_project.login.controller;

import lombok.RequiredArgsConstructor;
import org.example.newschedule_project.login.service.LoginService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;
}
