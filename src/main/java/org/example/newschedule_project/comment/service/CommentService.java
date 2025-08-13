package org.example.newschedule_project.comment.service;

import lombok.RequiredArgsConstructor;
import org.example.newschedule_project.comment.dto.CommentCreateRequest;
import org.example.newschedule_project.comment.dto.CommentResponse;
import org.example.newschedule_project.comment.dto.CommentUpdateRequest;
import org.example.newschedule_project.comment.entity.Comment;
import org.example.newschedule_project.comment.repository.CommentRepository;
import org.example.newschedule_project.schedule.entity.Schedule;
import org.example.newschedule_project.schedule.repository.ScheduleRepository;
import org.example.newschedule_project.user.entity.User;
import org.example.newschedule_project.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final ScheduleRepository scheduleRepository;

    // 댓글 생성
    @Transactional
    public CommentResponse create(Long userId, Long scheduleId, CommentCreateRequest createRequest) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("그럴리 없겠지만 뭔가 잘못된 것이 분명")
        );
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 게시물입니다.")
        );
        Comment comment = commentRepository.save(new Comment(createRequest.getComment(), user, schedule));
        return new CommentResponse(comment);
    }
    // 해당 스케줄 내에 내가 작성한 댓글 전체 조회.
    @Transactional(readOnly = true)
    public List<CommentResponse> findAll(Long userId, Long scheduleId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("그럴리 없겠지만 뭔가 잘못된 것이 분명")
        );
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 게시물입니다.")
        );
        List<Comment> comments = commentRepository.findAllByUserAndSchedule(user, schedule);
        return comments.stream().map(CommentResponse::new).toList();
    }
    // 내가 작성한 댓글 전체 조회.
    @Transactional(readOnly = true)
    public List<CommentResponse> findAll(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("그럴리 없겠지만 뭔가 잘못된 것이 분명")
        );
        List<Comment> comments = commentRepository.findAllByUser(user);
        return comments.stream().map(CommentResponse::new).toList();
    }
    // 내가 작성한 댓글 단건 조회
    @Transactional(readOnly = true)
    public CommentResponse findById(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 댓글입니다.")
        );
        return new CommentResponse(comment);
    }
    // 댓글 수정
    @Transactional
    public CommentResponse update(Long commentId, CommentUpdateRequest updateRequest) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 댓글입니다.")
        );
        comment.changeContent(updateRequest);
        return new CommentResponse(comment);
    }
    // 댓글 삭제
    @Transactional
    public void deleteById(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 댓글입니다.")
        );
        commentRepository.delete(comment);
    }
}
