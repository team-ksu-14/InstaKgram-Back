package me.instakgram.boot.member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@Entity @Table
public class Member implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String password;

    @Column
    private String profileImageUrl;

    @Column
    private String website;

    @Column
    private String introduce;

    @Column(nullable = false)
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime updatedDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "FOLLOW",
                joinColumns = @JoinColumn(name = "idx"),
                inverseJoinColumns = @JoinColumn(name = "followers_idx"))
    private List<Member> followers = new ArrayList<>();

    @Builder
    public Member(String name, String email, String password, String profileImageUrl, String nickname, String website, String introduce, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.profileImageUrl = profileImageUrl;
        this.nickname = nickname;
        this.website = website;
        this.introduce = introduce;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Member update(MemberUpdateDto memberUpdateDto) {
        this.email = memberUpdateDto.getEmail() == null ? this.email : memberUpdateDto.getEmail();
        this.name = memberUpdateDto.getName() == null ? this.name : memberUpdateDto.getName();
        this.nickname = memberUpdateDto.getNickname() == null ? this.nickname : memberUpdateDto.getNickname();
        this.profileImageUrl = memberUpdateDto.getProfileImageUrl() == null ? this.profileImageUrl : memberUpdateDto.getProfileImageUrl();
        this.website = memberUpdateDto.getWebsite() == null ? this.website : memberUpdateDto.getWebsite();
        this.introduce = memberUpdateDto.getIntroduce() == null ? this.introduce : memberUpdateDto.getIntroduce();
        this.updatedDate = LocalDateTime.now();
        return this;
    }

}
