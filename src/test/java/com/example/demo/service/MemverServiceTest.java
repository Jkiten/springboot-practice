package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MemoryMemberRepository;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class MemverServiceTest {
/*
    MemverService memverService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memverService = new MemverService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }


    @Test
    void join() {
        //given
        Member mermer =  new Member();
        mermer.setName("hello");

        //when
        Long saveId = memverService.join(mermer);

        //then
        Member findMember = memverService.findOne(saveId).get();
        Assertions.assertThat(mermer.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void findMembers() {
        //중복테스트
        //given
        Member member1 = new Member();
        member1.setName("spring1");

        Member member2 = new Member();
        member2.setName("spring1");

        //when
        memverService.join(member1);
        IllegalStateException e =assertThrows(IllegalStateException.class,()->memverService.join(member2));
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

//        try {
//            memverService.join(member2);
//            fail();
//        }catch (IllegalStateException e){
//            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }

        //then
    }

    */

    @Autowired
    MemverService memverService;
    @Autowired
    MemberRepository memberRepository;



    @Test
    void join() {
        //given
        Member mermer =  new Member();
        mermer.setName("hello");

        //when
        Long saveId = memverService.join(mermer);

        //then
        Member findMember = memverService.findOne(saveId).get();
        Assertions.assertThat(mermer.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void findMembers() {
        //중복테스트
        //given
        Member member1 = new Member();
        member1.setName("spring1");

        Member member2 = new Member();
        member2.setName("spring1");

        //when
        memverService.join(member1);
        IllegalStateException e =assertThrows(IllegalStateException.class,()->memverService.join(member2));
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }

}