package org.example.newschedule_project.login.service;

import lombok.RequiredArgsConstructor;
import org.example.newschedule_project.login.dto.LoginRequest;
import org.example.newschedule_project.login.dto.LoginResponse;
import org.example.newschedule_project.login.dto.SignUpRequest;
import org.example.newschedule_project.user.entity.User;
import org.example.newschedule_project.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        User user = this.userRepository.findUserByEmail(loginRequest.getEmail()).orElseThrow(
                () -> new IllegalArgumentException("존재하는 이메일이 없습니다.")
        );
        if(!user.getPassword().equals(loginRequest.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        return new LoginResponse(user);
    }
}
