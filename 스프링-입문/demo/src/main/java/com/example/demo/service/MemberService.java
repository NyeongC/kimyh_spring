package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {


    // 이렇게 써버리면 외부에서 서비스를 부를때 안에 쓰는 멤버 리포지토리와 그 서비스의 새롭게 선언한 멤버 리포지토리가 다른 객체임
    //private final MemberRepository memberRepository = new MemoryMemberRepository();


    // DI 개념
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
         this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */

    public Long join(Member member){

        // 유효성 검증
        validateDuplicateMember(member);

        memberRepository.save(member);


        return member.getId();
    }

    private void validateDuplicateMember(Member member){
        memberRepository.findByName(member.getName())
                .ifPresent(m-> {
                    throw new IllegalStateException("이미 존재하는 회원 입니다.");
                });
    }

    /*
    * 회원 전체 조회
    * */

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
