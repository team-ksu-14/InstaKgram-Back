package me.instakgram.boot.member;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

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

    @Builder
    public Member(String name, String email, String password, String profileImageUrl, String nickname, String website, String introduce, LocalDateTime createdDate) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.profileImageUrl = profileImageUrl;
        this.nickname = nickname;
        this.website = website;
        this.introduce = introduce;
        this.createdDate = createdDate;
    }
}
