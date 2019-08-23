package me.instakgram.boot.follow;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FollowingService {

    private final FollowingRepository followingRepository;

    public Following save(FollowingDto followingDto) {
        return followingRepository.save(followingDto.toEntity());
    }
}
