package org.example.newschedule_project.schedule.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ScheduleSaveRequest {

    private String name;
    @NotNull(message = "제목을 입력하시오.")
    private String title;
    @NotEmpty(message = "내용을 입력하시오.")
    private String content;
}
