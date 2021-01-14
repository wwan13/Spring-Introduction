package example.service;

import example.domain.Member;
import example.repository.MemberRepository;
import example.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * 스프링 없이 순수 자바 코드로만 테스트 하는 방법
 * 스프링을 거치는 것 보다 훨씬 빠르기 때문에
 * 이 테스트 방법을 사용하는 방법이 더 바람직
 */
class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

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

        /*
        try {
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e) {
            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }

         */

        // then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}
