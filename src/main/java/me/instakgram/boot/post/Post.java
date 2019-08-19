package me.instakgram.boot.post;

import lombok.*;
import me.instakgram.boot.member.Member;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@Entity @Table
public class Post implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private LocalDateTime createdDate;

    @OneToOne(fetch = FetchType.LAZY)
    private Member member;

    @Builder
    public Post(String contents, String imageUrl, LocalDateTime createdDate, Member member) {
        this.contents = contents;
        this.imageUrl = imageUrl;
        this.createdDate = createdDate;
        this.member = member;
    }
}
