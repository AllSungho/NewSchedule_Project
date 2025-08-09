package org.example.newschedule_project.service;

import lombok.RequiredArgsConstructor;
import org.example.newschedule_project.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
}
