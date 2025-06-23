package tobyspring.splearn.domain;

// 불변 객체를 만드는데 뛰어난 record -> 자주 써버릇 해야된다.
public record MemberCreateRequest(String email, String nickname, String password) {
}
