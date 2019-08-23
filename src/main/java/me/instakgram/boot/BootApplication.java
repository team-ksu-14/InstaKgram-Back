package me.instakgram.boot;

import me.instakgram.boot.member.MemberRegisterDto;
import me.instakgram.boot.member.MemberService;
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
    public CommandLineRunner runner(MemberService memberService) {
        return args -> {
            IntStream.rangeClosed(1, 10).forEach(index -> memberService.save(MemberRegisterDto.builder()
                .name("user" + index)
                .nickname("user" + index + "name")
                .email("user" + index + "@gmail.com")
                .password("user" + index)
                .build()));
        };
    }

}
