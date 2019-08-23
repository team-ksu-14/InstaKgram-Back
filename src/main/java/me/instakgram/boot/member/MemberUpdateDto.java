package me.instakgram.boot.member;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter @Setter
@ToString
@Builder
@NoArgsConstructor
public class MemberUpdateDto {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String nickname;

    private String profileImageUrl;

    private String website;

    private String introduce;

    @Builder
    public MemberUpdateDto(String email, String name, String nickname, String profileImageUrl, String website, String introduce) {
        this.email = email;
        this.name = name;
        this.nickname = nickname;
        this.profileImageUrl = profileImageUrl;
        this.website = website;
        this.introduce = introduce;
    }
}
