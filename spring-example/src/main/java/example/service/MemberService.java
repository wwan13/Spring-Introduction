package example.service;

import example.domain.Member;
import example.repository.MemberRepository;
import example.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// command + shift + t => test class 자동 생성

/*
* Service : 서비스 관련 메소드 들을 작성하는 클래스
* */
//@Service


public class MemberService {

    private final MemberRepository memberRepository;

    /*
    * @Autowired 를 붙히면 스프링 컨테이너에 등록되어있는 레포지토리를
    * 자동으 불러옴 -> new 를 하지 않아 새로운 인스턴스를 생성하지 않음
    * */
    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원x
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
