package example.repository;

import example.domain.Member;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {

    private final EntityManager em;

    // jpa 사용을 위해선 entity manager 필요
    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {

        em.persist(member);
        return member;

    }

    // pk 기반의 쿼리는 간단한 함수로 가능
    @Override
    public Optional<Member> findById(Long id) {

        Member member = em.find(Member.class, id);

        // 값이 없으면 null 을 반환하는 메소드을
        return Optional.ofNullable(member);

    }

    // pk 기반이 아닌 일반 필드 기반의 쿼리문은 jpql  작성 해 주어야 함
    @Override
    public Optional<Member> findByName(String name) {

        // Query 문을 날림
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name).getResultList();

        // 메소드 자료형이 Optional 이므로 찾은 값 하나만 반환
        return result.stream().findAny();

    }

    @Override
    public List<Member> findAll() {

        // 객체 자체를 불러옴
        List<Member> result = em.createQuery("select m from Member m", Member.class).getResultList();

        return result;

    }
}
