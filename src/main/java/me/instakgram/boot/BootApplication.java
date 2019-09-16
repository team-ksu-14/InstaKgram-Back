package me.instakgram.boot;

import me.instakgram.boot.member.Member;
import me.instakgram.boot.member.MemberRegisterDto;
import me.instakgram.boot.member.MemberService;
import me.instakgram.boot.post.PostRegisterDto;
import me.instakgram.boot.post.PostService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.IntStream;

@SpringBootApplication
public class BootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(MemberService memberService, PostService postService){
        return args -> {
            IntStream.rangeClosed(1, 100).forEach(index ->
                    memberService.save(MemberRegisterDto.builder()
                            .email("test" + index + "@ks.ac.kr")
                            .name("테스트 이름" + index)
                            .nickname("테스트 닉네임" + index)
                            .password("1q2w3e4r!" + index)
                            .build()));

            IntStream.rangeClosed(1, 10).forEach(index ->
                    postService.save(PostRegisterDto.builder()
                            .contents("테스트 내용 " + index)
                            .imageUrl("placeimg.com/256/256/" + index)
                            .build()));
        };
    }

}
