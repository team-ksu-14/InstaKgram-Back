package me.instakgram.boot.post;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter @Setter
@ToString
@NoArgsConstructor
public class PostRegisterDto {

    @NotBlank
    private String contents;

    @NotBlank
    private String imageUrl;

    @Builder
    public PostRegisterDto(String contents, String imageUrl) {
        this.contents = contents;
        this.imageUrl = imageUrl;
    }

    public Post toEntity() {
        Post post = new Post();
        post.setContents(this.contents);
        post.setImageUrl(this.imageUrl);
        post.setCreatedDate(LocalDateTime.now());
        return post;
    }
}
