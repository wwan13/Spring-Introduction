package example.repository;

import example.domain.Member;

import java.util.List;
import java.util.Optional;

// 유지보수를 위해 인터페이스 작성
public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
