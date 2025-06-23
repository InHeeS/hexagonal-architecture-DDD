package tobyspring.splearn.domain;


import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.apache.tomcat.util.http.parser.TE;
import org.junit.jupiter.api.Test;

class MemberTest {
    @Test
    void createMember(){
        var member = new Member("toby@splearn.app", "Toby", "secret");

        assertThat(member.getStatus()).isEqualTo(MemberStatus.PENDING);
    }

    @Test
    void constructorNullCheck() {
        assertThatThrownBy(() -> new Member(null, "Toby", "secret"))
            .isInstanceOf(NullPointerException.class);
    }

    @Test
    void activate() {
        var member = new Member("toby", "Toby", "secret");

        member.activate();

        assertThat(member.getStatus()).isEqualTo(MemberStatus.ACTIVE);
    }

    @Test
    void activateFail() {
        var member = new Member("toby", "Toby", "secret");

        member.activate();

        assertThatThrownBy(() ->{
            member.activate();
        }).isInstanceOf(IllegalArgumentException.class);

    }
    
    @Test
    void deactivate() {
        var member = new Member("toby", "Toby", "secret");
        member.activate();

        member.deactivate();

        assertThat(member.getStatus()).isEqualTo(MemberStatus.DEACTIVATED);
    }

    @Test
    void deactivateFail() {
        var member = new Member("toby", "Toby", "secret");

        assertThatThrownBy(() ->{
            member.deactivate();
        }).isInstanceOf(IllegalArgumentException.class);

        member.activate();
        member.deactivate();

        assertThatThrownBy(() -> member.deactivate() ).isInstanceOf(IllegalArgumentException.class);

    }
}