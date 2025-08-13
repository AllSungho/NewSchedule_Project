package org.example.newschedule_project.schedule.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.newschedule_project.schedule.dto.ScheduleResponse;
import org.example.newschedule_project.schedule.dto.ScheduleSaveRequest;
import org.example.newschedule_project.schedule.dto.ScheduleUpdateRequest;
import org.example.newschedule_project.schedule.service.ScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    // 일정 저장
    @PostMapping("/users/{userId}/schedules")
    public ResponseEntity<ScheduleResponse> saveSchedule(
            @PathVariable Long userId,
            @Valid @RequestBody ScheduleSaveRequest scheduleSaveRequest
    ) {
        return ResponseEntity.ok(this.scheduleService.saveSchedule(userId, scheduleSaveRequest));
    }
    // 한 유저가 작성한 스케줄 전체 조회
    @GetMapping("/users/{userId}/schedules")
    public ResponseEntity<List<ScheduleResponse>> findSchedules(
            @PathVariable Long userId
    ) {
        return ResponseEntity.ok(this.scheduleService.findSchedules(userId));
    }
    // 단건 조회
    @GetMapping("/users/{userId}/schedules/{scheduleId}")
    public ResponseEntity<ScheduleResponse> findScheduleById(
            @PathVariable Long userId,
            @PathVariable Long scheduleId
    ) {
        return ResponseEntity.ok(this.scheduleService.findScheduleById(userId, scheduleId));
    }
    // 수정
    @PutMapping("/users/{userId}/schedules/{scheduleId}")
    public ResponseEntity<ScheduleResponse> update(
            @PathVariable Long userId,
            @PathVariable Long scheduleId,
            @Valid @RequestBody ScheduleUpdateRequest scheduleUpdateRequest
    ) {
        return ResponseEntity.ok(this.scheduleService.update(userId, scheduleId, scheduleUpdateRequest));
    }
    // 삭제
    @DeleteMapping("/users/{userId}/schedules/{scheduleId}")
    public void deleteScheduleById(
            @PathVariable Long userId,
            @PathVariable Long scheduleId
    ) {
        this.scheduleService.deleteScheduleById(userId, scheduleId);
    }
}
