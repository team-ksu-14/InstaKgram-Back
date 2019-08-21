package me.instakgram.boot.member;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getMembers(){
        return ResponseEntity.ok(memberService.getMembers());
    }

    @PostMapping
    public ResponseEntity<?> registerMember(@RequestBody MemberRegisterDto memberRegisterDto){
        return new ResponseEntity<>(memberService.save(memberRegisterDto), HttpStatus.CREATED);
    }
}
