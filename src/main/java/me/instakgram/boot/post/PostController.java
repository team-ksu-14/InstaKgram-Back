package me.instakgram.boot.post;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPosts(){
        return ResponseEntity.ok(postService.getPosts());
    }

    @PostMapping
    public ResponseEntity<?> registerPost(@RequestBody PostRegisterDto postRegisterDto) {
        return new ResponseEntity<>(postService.save(postRegisterDto), HttpStatus.CREATED);
    }

}
