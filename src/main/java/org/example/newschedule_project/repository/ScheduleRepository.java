package org.example.newschedule_project.repository;

import org.example.newschedule_project.entity.Schedule;
import org.example.newschedule_project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findAllByUser(User user);
}
