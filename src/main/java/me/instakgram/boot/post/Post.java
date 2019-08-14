package me.instakgram.boot.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.instakgram.boot.member.Member;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    private Long idx;

    private String desc;

    private String imageUrl;

    private LocalDateTime createdDate;

    private Member member;
}
