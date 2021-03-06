package com.example.demo;

import com.example.demo.repository.JdbcMemberRepository;
import com.example.demo.repository.JpaMemberRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MemoryMemberRepository;
import com.example.demo.service.MemverService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {
//    @Bean
//    public MemverService memverService(){
//        return new MemverService(memberRepository());
//    }
//    @Bean
//    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//    }

    //private DataSource dataSource;
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }
    @Bean
    public MemverService memberService() {
        return new MemverService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        // return new MemoryMemberRepository();
        // return new JdbcMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }

}
