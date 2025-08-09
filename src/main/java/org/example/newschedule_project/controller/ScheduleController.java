package org.example.newschedule_project.controller;

import lombok.RequiredArgsConstructor;
import org.example.newschedule_project.scheduledto.ScheduleResponse;
import org.example.newschedule_project.scheduledto.ScheduleSaveRequest;
import org.example.newschedule_project.scheduledto.ScheduleUpdateRequest;
import org.example.newschedule_project.service.ScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    // 일정 저장
    @PostMapping("/schedules")
    public ResponseEntity<ScheduleResponse> saveSchedule(
            @RequestBody ScheduleSaveRequest scheduleSaveRequest
    ) {
        return ResponseEntity.ok(this.scheduleService.saveSchedule(scheduleSaveRequest));
    }
    // 전체 조회
    @GetMapping("/schedules")
    public ResponseEntity<List<ScheduleResponse>> findSchedules() {
        return ResponseEntity.ok(this.scheduleService.findSchedules());
    }
    // 단건 조회
    @GetMapping("/schedules/{scheduleId}")
    public ResponseEntity<ScheduleResponse> findScheduleById(
            @PathVariable Long scheduleId
    ) {
        return ResponseEntity.ok(this.scheduleService.findScheduleById(scheduleId));
    }
    // 수정
    @PutMapping("/schedules/{scheduleId}")
    public ResponseEntity<ScheduleResponse> update(
            @PathVariable Long scheduleId,
            @RequestBody ScheduleUpdateRequest scheduleUpdateRequest
    ) {
        return ResponseEntity.ok(this.scheduleService.update(scheduleId, scheduleUpdateRequest));
    }
    // 삭제
    @DeleteMapping("/schedules/{scheduleId}")
    public void deleteScheduleById(
            @PathVariable Long scheduleId
    ) {
        this.scheduleService.deleteScheduleById(scheduleId);
    }
}
