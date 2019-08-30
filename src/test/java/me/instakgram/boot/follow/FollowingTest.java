package me.instakgram.boot.follow;

import me.instakgram.boot.member.Member;
import me.instakgram.boot.member.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FollowingTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private EntityManager em;

    @Test
    public void 팔로잉_초기테스트() {

        Member member1 = memberRepository.findByIdx(1L);
        Member member2 = memberRepository.findByIdx(2L);
        Member member3 = memberRepository.findByIdx(3L);
        Member member15 = memberRepository.findByIdx(15L);
        Member member42 = memberRepository.findByIdx(42L);

        member1.getFollowers().add(member2);
        member1.getFollowers().add(member3);
        member1.getFollowers().add(member42);

        member2.getFollowers().add(member15);

        member15.getFollowers().add(member3);

        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member15);

        String sql = "Select m From Member m Join m.followers f Where f.id = :idx";
        TypedQuery<Member> query = em.createQuery(sql, Member.class);
        query.setParameter("idx", 2L);

        List<Member> followers = query.getResultList();
        for (Member member : followers) {
            System.out.println(member.getIdx());
        }
    }

}