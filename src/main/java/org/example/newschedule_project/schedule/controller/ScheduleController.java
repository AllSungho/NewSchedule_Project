package org.example.newschedule_project.schedule.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
    @PostMapping("/schedules")
    public ResponseEntity<ScheduleResponse> saveSchedule(
            @Valid @RequestBody ScheduleSaveRequest scheduleSaveRequest,
            HttpServletRequest request
    ) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute("LOGIN_SECRETE");
        return ResponseEntity.ok(this.scheduleService.saveSchedule(userId, scheduleSaveRequest));
    }
    // 자신이 작성한 스케줄 전체 조회
    @GetMapping("/schedules")
    public ResponseEntity<List<ScheduleResponse>> findSchedules(
            HttpServletRequest request
    ) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute("LOGIN_SECRETE");
        return ResponseEntity.ok(this.scheduleService.findSchedules(userId));
    }
    // 단건 조회
    @GetMapping("/schedules/{scheduleId}")
    public ResponseEntity<ScheduleResponse> findScheduleById(
            @PathVariable Long scheduleId,
            HttpServletRequest request
    ) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute("LOGIN_SECRETE");
        return ResponseEntity.ok(this.scheduleService.findScheduleById(userId, scheduleId));
    }
    // 일정 수정
    @PutMapping("/schedules/{scheduleId}")
    public ResponseEntity<ScheduleResponse> update(
            @PathVariable Long scheduleId,
            @Valid @RequestBody ScheduleUpdateRequest scheduleUpdateRequest,
            HttpServletRequest request
    ) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute("LOGIN_SECRETE");
        return ResponseEntity.ok(this.scheduleService.update(userId, scheduleId, scheduleUpdateRequest));
    }
    // 일정 삭제
    @DeleteMapping("/schedules/{scheduleId}")
    public void deleteScheduleById(
            @PathVariable Long scheduleId,
            HttpServletRequest request
    ) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute("LOGIN_SECRETE");
        this.scheduleService.deleteScheduleById(userId, scheduleId);
    }
}
