package me.instakgram.boot.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Post save(PostRegisterDto postRegisterDto) {
        return postRepository.save(postRegisterDto.toEntity());
    }
}
