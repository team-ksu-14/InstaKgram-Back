package me.instakgram.boot.member;

import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;

    public Member save(MemberRegisterDto memberRegisterDto) {
        memberRegisterDto.setPassword(passwordEncoder.encode(memberRegisterDto.getPassword()));
        return memberRepository.save(memberRegisterDto.toEntity());
    }

    public Resources getMembers() {
        List<Member> members = memberRepository.findAll();
        Resources<Member> resources = new Resources<>(members);
        resources.add(linkTo(methodOn(MemberController.class).getMembers()).withSelfRel());
        return resources;
    }

    public Member updateMember(Long idx, MemberUpdateDto memberUpdateDto) {
        Member updateMember = memberRepository.findByIdx(idx);
        updateMember.update(memberUpdateDto);
        return memberRepository.save(updateMember);
    }

    public Resource getMember(Long idx) {
        Member member = memberRepository.findByIdx(idx);
        Resource<Member> resource = new Resource<>(member);
        resource.add(linkTo(methodOn(MemberController.class).getMember(idx)).withSelfRel());
        return resource;
    }
}
