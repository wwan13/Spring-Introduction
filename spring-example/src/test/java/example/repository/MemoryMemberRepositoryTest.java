package example.repository;

import example.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

/**
 * 현제 구현 클래스를 먼저 만들고 테스트 작성
 * 하지만 테스트케이스를 먼저 작성 해보고, 그 다음 구현을 하는 방식을
 * 테스트 주도 개발 TDD 라고 한다.
 */

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 각 테스트가 끝날때마다 이 함수 실행
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("wwan");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
//        System.out.println("result = " + (result == member));
//        Assertions.assertEquals(member, result);

        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("MVC");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("MVC2");
        repository.save(member2);

        Member result = repository.findByName("MVC").get();

        Assertions.assertThat(result).isEqualTo(member1);
    }

    // 지금 언어는 자바다. 세미콜론 꼭 잊지 말것
    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        Assertions.assertThat(result.size()).isEqualTo(2);
    }

}
