package org.example.newschedule_project.comment.dto;

import lombok.Getter;
import org.example.newschedule_project.comment.entity.Comment;

import java.time.LocalDateTime;

@Getter
public class CommentResponse {

    private final Long id;
    private final String comment;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public CommentResponse(Comment comment) {
        this.id = comment.getId();
        this.comment = comment.getContent();
        this.createdAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();
    }
}
