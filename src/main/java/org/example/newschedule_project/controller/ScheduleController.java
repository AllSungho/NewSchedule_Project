package org.example.newschedule_project.controller;

import lombok.RequiredArgsConstructor;
import org.example.newschedule_project.scheduledto.ScheduleResponse;
import org.example.newschedule_project.scheduledto.ScheduleSaveRequest;
import org.example.newschedule_project.service.ScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
    public ResponseEntity<ScheduleResponse> saveSchedule(
            @RequestBody ScheduleSaveRequest scheduleSaveRequest
    ) {
        return ResponseEntity.ok(this.scheduleService.saveSchedule(scheduleSaveRequest));
    }
}
