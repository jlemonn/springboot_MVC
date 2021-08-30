package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

//    RequiredArgsContrcutor로 대체 가능
//    @Autowired
//    // 생성자 injection
//    public MemberService(MemberRepository memberRepository){
//        this.memberRepository = memberRepository;
//    }

    // 회원가입
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    };

    @Transactional
    private void validateDuplicateMember(Member member){
        // EXCEPTION
        // name을 unique하게 제약조건을 거는 것이 좋다. 같은 name에 접근할 문제가 있음.
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if(!findMembers.isEmpty()) {
            throw new IllegalStateException("member already exist.");
        }
    };
    
    // 회원 전체 조회
    private List<Member> findMember(){
        return memberRepository.findAll();
    }

    // 회원 한 명 조회
    private Member findOne(Member member) {
        return memberRepository.findOne(member.getId());
    }
}
