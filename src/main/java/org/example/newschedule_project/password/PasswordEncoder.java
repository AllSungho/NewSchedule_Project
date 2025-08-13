package org.example.newschedule_project.password;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoder {
    // 비밀번호 암호화
    public String encoding(String password) {
        return BCrypt.withDefaults().hashToString(BCrypt.MIN_COST, password.toCharArray());
    }
    // 비밀번호 비교
    public boolean matches(String password, String encodedPassword) {
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), encodedPassword);
        return result.verified;
    }
}
