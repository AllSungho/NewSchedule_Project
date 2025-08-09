package org.example.newschedule_project.repository;

import org.example.newschedule_project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
