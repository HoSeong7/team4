package com.keduit.helloworld.repositoryTests;

import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.keduit.helloworld.entity.Member;
import com.keduit.helloworld.repository.MemberRepository;

@SpringBootTest
public class MemberTests {

   @Autowired
   private MemberRepository repository;
   
   @Test
   public void insertMemberTest() {
      
      IntStream.rangeClosed(1, 10).forEach(i->{
         Member entity = Member.builder()
                          .id("user" + i)
                          .pw("1111")
                          .memberName(i+"이름")
                          .nickname(i+"별명")
                          .introduce("저는 " + i + "입니다 !!")
                          .email(i+"@abc.com")
                          .build();
         repository.save(entity);
      });
   }
   
   @Test
   public void selectMemberTest() {
      Optional<Member> result = repository.findById(2);
      
      System.out.println(result);
   }
   
   @Test
   public void updateMemberTest() {
      
      Member entity = Member.builder().memberNum(2)
                              .id("수정된아이디")
                              .pw("1234")
                              .memberName("수정한 이름1")
                              .nickname("수정한별명1")
                              .introduce("저는 동그라미입니다.")
                              .build();
      
      System.out.println(repository.save(entity));
   }
   
   @Test
   public void deleteMemberTest() {
      repository.deleteById(1);
   }
   
   
}