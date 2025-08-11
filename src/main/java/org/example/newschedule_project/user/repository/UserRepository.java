package org.example.newschedule_project.user.repository;

import org.example.newschedule_project.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
