package org.example.newschedule_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class NewScheduleProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewScheduleProjectApplication.class, args);
    }

}
