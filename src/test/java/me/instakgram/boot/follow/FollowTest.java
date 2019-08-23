package me.instakgram.boot.follow;

import me.instakgram.boot.member.Member;
import me.instakgram.boot.member.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FollowTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 팔로우_테스트() {
        memberRepository.save(Member.builder()
                .name("user")
                .nickname("username")
                .password("1234")
                .email("user@gmail.com")
                .createdDate(LocalDateTime.now())
                .build());

        Member member = memberRepository.findByEmail("user@gmail.com");

        Follow follow = new Follow();
        follow.setFollower(member.getIdx());
        follow.setFollowing(member.getIdx());
        follow.setMember(member);
        member.add(follow);

        System.out.println("*****************");
        System.out.println(follow.getFollower() + follow.getFollowing());
    }

}