package org.example.newschedule_project.comment.repository;

import org.example.newschedule_project.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
