package com.example.review.repository;

import com.example.review.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @Test
    void save() {
        Member member1 = new Member();
        member1.setName("ccn");
        memberRepository.save(member1);

        Member result = memberRepository.findByName("ccn1").get();

        Assertions.assertThat(result).isEqualTo(member1);


    }

    @Test
    void findById() {
    }

    @Test
    void findByName() {
    }

    @Test
    void findAll() {
    }

    @Test
    void clearStore() {
    }
}