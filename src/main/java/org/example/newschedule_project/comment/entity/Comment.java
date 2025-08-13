package org.example.newschedule_project.comment.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.newschedule_project.BaseEntity;
import org.example.newschedule_project.comment.dto.CommentUpdateRequest;
import org.example.newschedule_project.schedule.entity.Schedule;
import org.example.newschedule_project.user.entity.User;

@Entity
@Getter
@NoArgsConstructor
public class Comment extends BaseEntity {
    // 댓글 내용, 작성일, 수정일, 유저 고유 식별자, 일정 고유 식별자
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule;

    public Comment(String content, User user, Schedule schedule) {
        this.content = content;
        this.user = user;
        this.schedule = schedule;
    }

    public void changeContent(CommentUpdateRequest commentUpdateRequest) {
        this.content = commentUpdateRequest.getComment();
    }
}
