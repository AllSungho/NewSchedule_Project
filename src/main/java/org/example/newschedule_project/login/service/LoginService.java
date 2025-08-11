package org.example.newschedule_project.login.service;

import lombok.RequiredArgsConstructor;
import org.example.newschedule_project.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
}
