package org.example.newschedule_project.user.service;

import lombok.RequiredArgsConstructor;
import org.example.newschedule_project.user.entity.User;
import org.example.newschedule_project.user.repository.UserRepository;
import org.example.newschedule_project.user.dto.UserResponse;
import org.example.newschedule_project.user.dto.UserUpdateReqeust;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // 전체 조회
    @Transactional(readOnly = true)
    public List<UserResponse> findUsers() {
        List<User> users = this.userRepository.findAll();
        return users.stream().map(UserResponse::new).toList();
    }
    // 단건 조회
    @Transactional(readOnly = true)
    public UserResponse findUserById(Long id) {
        User user = this.userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 아이디입니다.")
        );
        return new UserResponse(user);
    }
    // 수정
    @Transactional
    public UserResponse update(Long id, UserUpdateReqeust userUpdateRequest) {
        User user = this.userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 아이디입니다.")
        );
        // 전체 수정
        user.updateInfo(userUpdateRequest);
        return new UserResponse(user);
    }
    // 삭제
    @Transactional
    public void deleteUserById(Long id) {
        User user = this.userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 아이디입니다.")
        );
        this.userRepository.delete(user);
    }
}
