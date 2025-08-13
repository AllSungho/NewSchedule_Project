package org.example.newschedule_project.comment.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.newschedule_project.comment.dto.CommentCreateRequest;
import org.example.newschedule_project.comment.dto.CommentResponse;
import org.example.newschedule_project.comment.dto.CommentUpdateRequest;
import org.example.newschedule_project.comment.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    // 댓글 생성
    @PostMapping("/schedules/{scheduleId}/comments")
    public ResponseEntity<CommentResponse> create(
            @PathVariable Long scheduleId,
            @RequestBody CommentCreateRequest commentCreateRequest,
            HttpServletRequest request
    ) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute("LOGIN_SECRETE"); // <- Null
        return ResponseEntity.ok(this.commentService.create(userId, scheduleId, commentCreateRequest));
    }
    // 전체 댓글 조회
    @GetMapping("/comments")
    public ResponseEntity<List<CommentResponse>> findAll(
            @RequestParam Long scheduleId,
            HttpServletRequest request
    ) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute("LOGIN_SECRETE");
        if(scheduleId == null) {
            return ResponseEntity.ok(this.commentService.findAll(userId));
        }
        return ResponseEntity.ok(this.commentService.findAll(userId, scheduleId));
    }
    // 댓글 단건 조회
    @GetMapping("/comments/{commentId}")
    public ResponseEntity<CommentResponse> findById(
            @PathVariable Long commentId,
            HttpServletRequest request
    ) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute("LOGIN_SECRETE");
        return ResponseEntity.ok(this.commentService.findById(userId, commentId));
    }
    // 댓글 수정
    @PutMapping("/comments/{commentId}")
    public ResponseEntity<CommentResponse> update(
            @PathVariable Long commentId,
            @RequestBody CommentUpdateRequest commentUpdateRequest,
            HttpServletRequest request
    ) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute("LOGIN_SECRETE");
        return ResponseEntity.ok(this.commentService.update(userId, commentId, commentUpdateRequest));
    }
    // 댓글 삭제
    @DeleteMapping("/comments/{commentId}")
    public void deleteById(
            @PathVariable Long commentId,
            HttpServletRequest request
    ) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute("LOGIN_SECRETE");
        this.commentService.deleteById(userId, commentId);
    }
}
