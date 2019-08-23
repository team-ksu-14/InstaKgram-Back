package me.instakgram.boot.follow;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter @Setter
@ToString
@NoArgsConstructor
public class FollowingDto {

    @NotBlank
    private String nickname;

    @Builder
    public Following toEntity() {
        Following following = new Following();
        following.setNickname(this.nickname);
        return following;
    }
}
