package me.instakgram.boot.follow;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.instakgram.boot.member.Member;

import javax.persistence.*;
import java.io.Serializable;

@Getter @Setter
@NoArgsConstructor
@Entity @Table
public class Following implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String profileImageUrl;

    @Column(nullable = false)
    private String nickname;

    @Column
    private String introduce;

    @ManyToOne
    private Member member;

    public Following(String profileImageUrl, String nickname, String introduce) {
        this.profileImageUrl = profileImageUrl;
        this.nickname = nickname;
        this.introduce = introduce;
    }
}
