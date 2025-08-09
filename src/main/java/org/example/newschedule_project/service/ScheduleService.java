package org.example.newschedule_project.service;

import lombok.RequiredArgsConstructor;
import org.example.newschedule_project.entity.Schedule;
import org.example.newschedule_project.repository.ScheduleRepository;
import org.example.newschedule_project.scheduledto.ScheduleResponse;
import org.example.newschedule_project.scheduledto.ScheduleSaveRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleResponse saveSchedule(ScheduleSaveRequest scheduleSaveRequest) {
        Schedule schedule = this.scheduleRepository.save(
                new Schedule(
                        scheduleSaveRequest.getName(),
                        scheduleSaveRequest.getTitle(),
                        scheduleSaveRequest.getContent()
                )
        );
        return new ScheduleResponse(schedule);
    }
}
