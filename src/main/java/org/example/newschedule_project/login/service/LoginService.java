package org.example.newschedule_project.login.service;

import lombok.RequiredArgsConstructor;
import org.example.newschedule_project.login.dto.LoginRequest;
import org.example.newschedule_project.login.dto.LoginResponse;
import org.example.newschedule_project.login.dto.SignUpRequest;
import org.example.newschedule_project.user.entity.User;
import org.example.newschedule_project.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    // 회원가입
    @Transactional
    public LoginResponse signUp(SignUpRequest signUpRequest) {
        User user = this.userRepository.save(
                new User(
                        signUpRequest.getName(),
                        signUpRequest.getEmail(),
                        signUpRequest.getPassword()
                )
        );
        return new LoginResponse(user);
    }
    // 로그인
    @Transactional
    public LoginResponse login(LoginRequest loginRequest) {
        User user;
        try {
            // 로그인 시도 중 해당 이메일이 있는지를 확인
            user = this.userRepository.findUserByEmail(loginRequest.getEmail()).get();
        } catch (NoSuchElementException e) {
            return null;
        }
        // 로그인 시도 중 저장된 비밀번호가 일치한지를 확인
        if(!user.getPassword().equals(loginRequest.getPassword())) {
            return null;
        }
        return new LoginResponse(user);
    }
}
