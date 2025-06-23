package tobyspring.splearn.domain;

import static org.springframework.util.Assert.*;

import java.util.Objects;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.Assert;

@Getter
@ToString
public class Member {
    private String email;

    private String nickname;

    private String passwordHash;

    // @Getter(AccessLevel.NONE)
    private MemberStatus status;

    public Member(String email, String nickname, String passwordHash) {
        this.email = Objects.requireNonNull(email);
        this.nickname = Objects.requireNonNull(nickname);
        this.passwordHash = Objects.requireNonNull(passwordHash);
        this.status = MemberStatus.PENDING;
    }

    public void activate() {
        state(status == MemberStatus.PENDING, "PENDING 상태가 아닙니다. ");

        this.status = MemberStatus.ACTIVE;
    }

    public void deactivate() {
        state(status == MemberStatus.ACTIVE, "PENDING 상태가 아닙니다. ");

        this.status = MemberStatus.DEACTIVATED;
    }
}
