package org.example.newschedule_project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.newschedule_project.scheduledto.ScheduleUpdateRequest;

@Entity
@Getter
@NoArgsConstructor
public class Schedule extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String title;
    private String content;

    public Schedule(String name, String title, String content) {
        this.name = name;
        this.title = title;
        this.content = content;
    }
    public void updateInfo(ScheduleUpdateRequest scheduleUpdateRequest) {
        this.name = scheduleUpdateRequest.getName();
        this.title = scheduleUpdateRequest.getTitle();
        this.content = scheduleUpdateRequest.getContent();
    }
}
