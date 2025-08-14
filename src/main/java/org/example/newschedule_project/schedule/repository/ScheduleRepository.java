package org.example.newschedule_project.schedule.repository;

import org.example.newschedule_project.schedule.entity.Schedule;
import org.example.newschedule_project.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findAllByUser(User user);

    List<Schedule> findSchedulesByUser(User user);

    List<Schedule> findByUser(User user);

    void deleteAllByUser(User user);
}
