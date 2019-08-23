package me.instakgram.boot.member;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter @Setter
@ToString
@NoArgsConstructor
public class MemberRegisterDto {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String name;

    @NotBlank
    private String nickname;

    @NotBlank
    private String password;

    public MemberRegisterDto(@NotBlank @Email String email, @NotBlank String name, @NotBlank String nickname, @NotBlank String password) {
        this.email = email;
        this.name = name;
        this.nickname = nickname;
        this.password = password;
    }

    public Member toEntity() {
        Member member = new Member();
        member.setEmail(this.email);
        member.setName(this.name);
        member.setNickname(this.nickname);
        member.setPassword(this.password);
        member.setCreatedDate(LocalDateTime.now());
        return member;
    }
}
