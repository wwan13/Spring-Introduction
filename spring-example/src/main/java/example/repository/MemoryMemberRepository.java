package example.repository;

import example.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;


/*
* Repository -> 데이터베이스 관련 로직들. 다양한 query 등의 메소드를 작성하는 클래스
* @Repository 를 작성 해 주면 스프링 컨테이너에 자동으로 등록
* */
//@Repository


public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;


    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        /* lambda => 추가 공부 필요 */
        return store.values().stream().filter(member -> member.getName().equals(name)).findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
