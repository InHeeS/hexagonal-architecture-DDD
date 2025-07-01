package tobyspring.splearn.domain.member;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

// 불변 객체를 만드는데 뛰어난 record -> 자주 써버릇 해야된다.
public record MemberRegisterRequest(
    @Email String email,
    @Size(min = 5, max = 20) String nickname,
    @Size(min = 8, max = 100) String password
) {

}
