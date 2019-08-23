package me.instakgram.boot.follow;

import me.instakgram.boot.member.Member;
import me.instakgram.boot.member.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FollowingTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    FollowingRepository followingRepository;

    @Test
    public void 팔로잉_테스트() {
        Member member = memberRepository.findAll().get(0);
        Following following = new Following();
        following.setMember(member);
        following.setNickname(member.getNickname());
        followingRepository.save(following);
    }

}