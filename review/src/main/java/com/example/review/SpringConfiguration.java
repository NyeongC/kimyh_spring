package com.example.review;

import com.example.review.repository.JdbcTemplateMemberRepository;
import com.example.review.repository.MemberRepository;
import com.example.review.repository.MemoryMemberRepository;
import com.example.review.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfiguration {

    private final DataSource dataSource;
    public SpringConfiguration(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        //return new MemoryMemberRepository();
        return new JdbcTemplateMemberRepository(dataSource);
    }

}
