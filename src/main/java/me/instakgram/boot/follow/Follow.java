package me.instakgram.boot.follow;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.instakgram.boot.member.Member;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@Entity @Table
public class Follow implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idx;

    @Column
    private Long following;

    @Column
    private Long follower;

    @ManyToOne
    private Member member;

    @Builder
    public Follow(Long following, Long follower, Member member) {
        this.following = following;
        this.follower = follower;
        this.member = member;
    }
}
