package org.example.newschedule_project.service;

import lombok.RequiredArgsConstructor;
import org.example.newschedule_project.entity.Schedule;
import org.example.newschedule_project.repository.ScheduleRepository;
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
    // 저장
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
    // 전체 조회
    @Transactional(readOnly = true)
    public List<ScheduleResponse> findSchedules() {
        List<Schedule> schedules = this.scheduleRepository.findAll();
        return schedules.stream().map(ScheduleResponse::new).toList();
    }
    // 단건 조회
    @Transactional(readOnly = true)
    public ScheduleResponse findScheduleById(Long id) {
        Schedule schedule = this.scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 아이디입니다.")
        );
        return new ScheduleResponse(schedule);
    }
    // 수정
    @Transactional
    public ScheduleResponse update(Long id, ScheduleUpdateRequest scheduleUpdateRequest) {
        Schedule schedule = this.scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 아이디입니다.")
        );
        // 정보 수정
        schedule.updateInfo(scheduleUpdateRequest);
        return new ScheduleResponse(schedule);
    }
    // 삭제
    @Transactional
    public void deleteScheduleById(Long id) {
        Schedule schedule = this.scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 아이디입니다.")
        );
        this.scheduleRepository.delete(schedule);
    }
}
