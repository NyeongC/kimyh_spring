package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {

        // given
        Member member = new Member(1L, "ccn", Grade.BASIC);

        // when
        memberService.join(member);
        Member finMember1 =  memberService.findMember(2L);


        // then
        Assertions.assertThat(member).isEqualTo(finMember1);
    }

    @Test
    void findMember() {
    }
}