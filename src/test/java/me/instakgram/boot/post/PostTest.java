package me.instakgram.boot.post;

import me.instakgram.boot.member.Member;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class PostTest {

    @Test
    public void post_초기_테스트(){

        Post post = Post.builder()
                .desc("내용")
                .imageUrl("https://~")
                .createdDate(LocalDateTime.now())
                .member(new Member())
                .build();

        assertThat(post).isNotNull();
    }
}