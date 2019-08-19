package me.instakgram.boot.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;

    public Member save(MemberRegisterDto memberRegisterDto) {
        memberRegisterDto.setPassword(passwordEncoder.encode(memberRegisterDto.getPassword()));
        return memberRepository.save(memberRegisterDto.toEntity());
    }
}
