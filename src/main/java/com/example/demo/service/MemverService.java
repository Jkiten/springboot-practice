package com.example.demo.service;

import static ch.qos.logback.core.joran.spi.ConsoleTarget.findByName;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MemoryMemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
public class MemverService {
    private final MemberRepository memberRepository;

//    public MemverService(){
//
//    }
    //@Autowired
    public MemverService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }


    /**
     * 회원가입
     */
    public Long join(Member member){
//        Optional<Member> result=  memberRepository.findByName(member.getName());
//        result.ifPresent(m->{
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });
        //c+alt+m
        validateDuplicateMemter(member);
        memberRepository.save(member);
        return member.getId();
    }
    /**
    * 전체 회원 조회
    */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long memberId){
        return  memberRepository.findById(memberId);
    }

    private void validateDuplicateMemter(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m->{
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }
}
