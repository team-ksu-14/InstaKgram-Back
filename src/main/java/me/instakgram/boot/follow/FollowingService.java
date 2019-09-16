package me.instakgram.boot.follow;

import lombok.RequiredArgsConstructor;
import me.instakgram.boot.member.Member;
import me.instakgram.boot.member.MemberRepository;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Service
@RequiredArgsConstructor
public class FollowingService {

    private final MemberRepository memberRepository;

    private final EntityManager em;

    public Resources getFollowingList(Long idx) {
        String sql = "Select f From Member m Join m.followers f Where m.id = :idx";
        TypedQuery<Member> query = em.createQuery(sql, Member.class);
        query.setParameter("idx", idx);

        List<Member> followings = query.getResultList();
        Resources<Member> resources = new Resources<>(followings);
        resources.add(linkTo(methodOn(FollowingController.class).getFollwings(idx)).withSelfRel());
        return resources;
    }

    public Resources getFollowerList(Long idx) {
        String sql = "Select m From Member m Join m.followers f Where f.id = :idx";
        TypedQuery<Member> query = em.createQuery(sql, Member.class);
        query.setParameter("idx", idx);

        List<Member> followers = query.getResultList();
        Resources<Member> resources = new Resources<>(followers);
        resources.add(linkTo(methodOn(FollowingController.class).getFollowers(idx)).withSelfRel());
        return resources;
    }

}
