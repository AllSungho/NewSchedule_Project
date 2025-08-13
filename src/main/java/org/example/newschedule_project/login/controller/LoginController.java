package org.example.newschedule_project.login.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.newschedule_project.login.dto.LoginRequest;
import org.example.newschedule_project.login.dto.LoginResponse;
import org.example.newschedule_project.login.dto.SignUpRequest;
import org.example.newschedule_project.login.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    // 회원가입
    @PostMapping("/signups")
    public ResponseEntity<LoginResponse> signup(
            @RequestBody SignUpRequest signUpRequest
            ) {
        return ResponseEntity.ok(loginService.signUp(signUpRequest));
    }
    // 로그인
    @PostMapping("/logins")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest loginRequest,
            HttpServletRequest request
    ) {
        // 쿠키 세션을 발급
        LoginResponse loginResponse = loginService.login(loginRequest);
        // 로그인 정보가 틀릴 시
        if(loginResponse == null) {
            // 401 상태 코드 반환
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        // 신규 세션 생성
        HttpSession session = request.getSession();
        session.setAttribute("LOGIN_SECRETE", loginResponse.getId());

        return ResponseEntity.ok(loginResponse);
    }
    // 로그아웃
    @PostMapping("/logouts")
    public void logout(
            HttpServletRequest request
    ) {
        // 로그인하지 않으면 HttpSession이 null로 반환된다.
        HttpSession session = request.getSession(false);
        // 세션이 존재하면 -> 로그인이 된 경우
        if (session != null) {
            // 해당 세션 삭제
            session.invalidate();
        }
    }
}
