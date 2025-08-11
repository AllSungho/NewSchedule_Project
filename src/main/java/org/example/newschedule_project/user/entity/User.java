package org.example.newschedule_project.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.newschedule_project.BaseEntity;
import org.example.newschedule_project.user.dto.UserUpdateReqeust;

@Entity
@Getter
@NoArgsConstructor
public class User extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public void updateInfo(UserUpdateReqeust userUpdateReqeust) {
        this.name = userUpdateReqeust.getName();
        this.email = userUpdateReqeust.getEmail();
        this.password = userUpdateReqeust.getPassword();
    }
}
