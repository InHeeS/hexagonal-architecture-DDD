package tobyspring.splearn.domain;

import org.springframework.stereotype.Repository;


public interface PasswordEncoder {
    String encode(String password);
    boolean matches(String password, String passwordHash);
}
