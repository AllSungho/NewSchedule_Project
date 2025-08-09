package org.example.newschedule_project.controller;

import lombok.RequiredArgsConstructor;
import org.example.newschedule_project.service.ScheduleService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;
}
