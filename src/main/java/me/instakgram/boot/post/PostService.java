package me.instakgram.boot.post;

import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Post save(PostRegisterDto postRegisterDto) {
        return postRepository.save(postRegisterDto.toEntity());
    }

    public List<Post> findAll(){
        return postRepository.findAll();
    }

    public Resources getPosts() {
        List<Post> posts = postRepository.findAll();
        Resources<Post> resources = new Resources<>(posts);
        resources.add(linkTo(methodOn(PostController.class).getPosts()).withSelfRel());
        return resources;
    }
}
