package org.example.newschedule_project.user.controller;

import lombok.RequiredArgsConstructor;
import org.example.newschedule_project.user.service.UserService;
import org.example.newschedule_project.user.dto.UserResponse;
import org.example.newschedule_project.user.dto.UserSaveRequest;
import org.example.newschedule_project.user.dto.UserUpdateReqeust;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 저장
    @PostMapping("/users")
    public ResponseEntity<UserResponse> save(
            @RequestBody UserSaveRequest userSaveRequest
    ) {
        return  ResponseEntity.ok(userService.save(userSaveRequest));
    }
    // 전체 조회
    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> findUsers() {
        return ResponseEntity.ok(userService.findUsers());
    }
    // 단건 조회
    @GetMapping("/users/{userId}")
    public ResponseEntity<UserResponse> findUserById(
            @PathVariable Long userId
    ) {
        return ResponseEntity.ok(userService.findUserById(userId));
    }
    // 수정
    @PutMapping("/users/{userId}")
    public ResponseEntity<UserResponse> update(
            @PathVariable Long userId,
            @RequestBody UserUpdateReqeust userUpdateRequest
    ) {
        return ResponseEntity.ok(userService.update(userId, userUpdateRequest));
    }
    // 삭제
    @DeleteMapping("/users/{userId}")
    public void deleteUserById(
            @PathVariable Long userId
    ) {
        this.userService.deleteUserById(userId);
    }
}
