package me.instakgram.boot.follow;

import lombok.RequiredArgsConstructor;
import me.instakgram.boot.member.Member;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/follow")
@RequiredArgsConstructor
public class FollowingController {

    private final FollowingService followingService;

    @GetMapping(value = "/{idx}/following", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getFollwings(@PathVariable Long idx) {
        return ResponseEntity.ok(followingService.getFollowingList(idx));
    }

    @GetMapping(value = "/{idx}/follower", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getFollowers(@PathVariable Long idx) {
        return ResponseEntity.ok(followingService.getFollowerList(idx));
    }

}
