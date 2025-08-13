package org.example.newschedule_project.comment.repository;

import org.example.newschedule_project.comment.entity.Comment;
import org.example.newschedule_project.schedule.entity.Schedule;
import org.example.newschedule_project.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByUserAndSchedule(User user, Schedule schedule);
    List<Comment> findAllByUser(User user);

    void deleteAllBySchedule(Schedule schedule);
}
