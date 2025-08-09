package org.example.newschedule_project.entity;

import jakarta.persistence.*;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Schedule(String name, String title, String content, User user) {
        this.name = name;
        this.title = title;
        this.content = content;
        this.user = user;
    }
    public void updateInfo(ScheduleUpdateRequest scheduleUpdateRequest) {
        this.name = scheduleUpdateRequest.getName();
        this.title = scheduleUpdateRequest.getTitle();
        this.content = scheduleUpdateRequest.getContent();
    }
}
