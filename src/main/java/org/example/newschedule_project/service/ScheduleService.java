package org.example.newschedule_project.service;

import lombok.RequiredArgsConstructor;
import org.example.newschedule_project.entity.Schedule;
import org.example.newschedule_project.entity.User;
import org.example.newschedule_project.repository.ScheduleRepository;
import org.example.newschedule_project.repository.UserRepository;
import org.example.newschedule_project.scheduledto.ScheduleResponse;
import org.example.newschedule_project.scheduledto.ScheduleSaveRequest;
import org.example.newschedule_project.scheduledto.ScheduleUpdateRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;
    // 저장
    @Transactional
    public ScheduleResponse saveSchedule(Long userId, ScheduleSaveRequest scheduleSaveRequest) {
        User user = this.userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("그런 아이디는 없습니다.")
        );
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
        User user = this.userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("그런 아이디는 없습니다.")
        );
        List<Schedule> schedules = this.scheduleRepository.findAllByUser(user);
        return schedules.stream().map(ScheduleResponse::new).toList();
    }
    // 단건 조회
    @Transactional(readOnly = true)
    public ScheduleResponse findScheduleById(Long scheduleId) {
        Schedule schedule = this.scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 아이디입니다.")
        );
        return new ScheduleResponse(schedule);
    }
    // 수정
    @Transactional
    public ScheduleResponse update(Long scheduleId, ScheduleUpdateRequest scheduleUpdateRequest) {
        Schedule schedule = this.scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 아이디입니다.")
        );
        // 정보 수정
        schedule.updateInfo(scheduleUpdateRequest);
        return new ScheduleResponse(schedule);
    }
    // 삭제
    @Transactional
    public void deleteScheduleById(Long scheduleId) {
        Schedule schedule = this.scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 아이디입니다.")
        );
        this.scheduleRepository.delete(schedule);
    }
}
