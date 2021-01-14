package example.service;

import example.domain.Member;
import example.repository.MemberRepository;
import example.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Spring 통합 테스트 코드
 */
@SpringBootTest
@Transactional  // 테스트한 db 데이터를 테스트가 끝나면 롤백
class MemberServiceIntegrationTest {

    /* 테스트 코드이기 때문에 constructor 을 쓰지 않고 필드에 바로 주입 해도 상관 없음 */
    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    void join() {
        // given
        Member member = new Member();
        member.setName("spring");

        // when
        Long savdId = memberService.join(member);

        // then
        Member findMember =  memberService.findOne(savdId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void exeptDuplicatedMember() {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        Assertions.assertThat(exception.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        // then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}
