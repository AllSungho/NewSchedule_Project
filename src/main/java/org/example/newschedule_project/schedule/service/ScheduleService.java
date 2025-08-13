package org.example.newschedule_project.schedule.service;

import lombok.RequiredArgsConstructor;
import org.example.newschedule_project.comment.repository.CommentRepository;
import org.example.newschedule_project.schedule.entity.Schedule;
import org.example.newschedule_project.user.entity.User;
import org.example.newschedule_project.schedule.repository.ScheduleRepository;
import org.example.newschedule_project.user.repository.UserRepository;
import org.example.newschedule_project.schedule.dto.ScheduleResponse;
import org.example.newschedule_project.schedule.dto.ScheduleSaveRequest;
import org.example.newschedule_project.schedule.dto.ScheduleUpdateRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    private User findUser(Long userId) {
        return this.userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("그런 아이디는 없습니다.")
        );
    }

    // 저장
    @Transactional
    public ScheduleResponse saveSchedule(Long userId, ScheduleSaveRequest scheduleSaveRequest) {
        User user = findUser(userId);
        Schedule schedule = this.scheduleRepository.save(
                new Schedule(
                        scheduleSaveRequest.getName(),
                        scheduleSaveRequest.getTitle(),
                        scheduleSaveRequest.getContent(),
                        user
                )
        );
        return new ScheduleResponse(schedule);
    }
    // 해당 유저 스케줄 전체 조회
    @Transactional(readOnly = true)
    public List<ScheduleResponse> findSchedules(Long userId) {
        User user = findUser(userId);
        List<Schedule> schedules = this.scheduleRepository.findAllByUser(user);
        return schedules.stream().map(ScheduleResponse::new).toList();
    }
    // 단건 조회
    @Transactional(readOnly = true)
    public ScheduleResponse findScheduleById(Long userId, Long scheduleId) {
        User user = findUser(userId);
        List<Schedule> schedules = this.scheduleRepository.findSchedulesByUser(user);
        Schedule schedule = schedules.stream()
                .filter(sche -> sche.getId().equals(scheduleId))
                .findFirst()
                .orElseThrow(
                () -> new IllegalArgumentException("그런 스케줄 아이디는 없습니다.")
                );
        return new ScheduleResponse(schedule);
    }
    // 수정
    @Transactional
    public ScheduleResponse update(Long userId, Long scheduleId, ScheduleUpdateRequest scheduleUpdateRequest) {
        User user = findUser(userId);
        List<Schedule> schedules = this.scheduleRepository.findSchedulesByUser(user);
        Schedule schedule = schedules.stream()
                .filter(sche -> sche.getId().equals(scheduleId))
                .findFirst()
                .orElseThrow(
                        () -> new IllegalArgumentException("그런 스케줄 아이디는 없습니다.")
                );
        // 정보 수정
        schedule.updateInfo(scheduleUpdateRequest);
        return new ScheduleResponse(schedule);
    }
    // 삭제
    @Transactional
    public void deleteScheduleById(Long userId, Long scheduleId) {
        User user = findUser(userId);
        List<Schedule> schedules = this.scheduleRepository.findSchedulesByUser(user);
        Schedule schedule = schedules.stream()
                .filter(sche -> sche.getId().equals(scheduleId))
                .findFirst()
                .orElseThrow(
                        () -> new IllegalArgumentException("그런 스케줄 아이디는 없습니다.")
                );
        this.commentRepository.deleteAllBySchedule(schedule);
        this.scheduleRepository.delete(schedule);
    }
}
