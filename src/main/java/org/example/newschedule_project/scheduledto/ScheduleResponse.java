package org.example.newschedule_project.scheduledto;

import lombok.Getter;
import org.example.newschedule_project.entity.Schedule;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponse {

    private final Long id;
    private final String name;
    private final String title;
    private final String content;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public ScheduleResponse(Schedule schedule, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = schedule.getId();
        this.name = schedule.getName();
        this.title = schedule.getTitle();
        this.content = schedule.getContent();
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
