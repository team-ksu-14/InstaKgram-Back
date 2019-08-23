package me.instakgram.boot.follow;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/followings")
@RequiredArgsConstructor
public class FollowingController {

    private final FollowingService followingService;

    @PostMapping
    public ResponseEntity<?> following(@RequestBody FollowingDto followingDto) {
        return new ResponseEntity<>(followingService.save(followingDto), HttpStatus.CREATED);
    }
}
