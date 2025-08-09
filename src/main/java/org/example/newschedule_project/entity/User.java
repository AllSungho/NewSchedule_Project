package org.example.newschedule_project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.newschedule_project.userdto.UserUpdateReqeust;

@Entity
@Getter
@NoArgsConstructor
public class User extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void updateInfo(UserUpdateReqeust userUpdateReqeust) {
        this.name = userUpdateReqeust.getName();
        this.email = userUpdateReqeust.getEmail();
    }
}
