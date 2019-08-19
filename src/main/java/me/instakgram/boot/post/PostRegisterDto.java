package me.instakgram.boot.post;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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

    public Post toEntity() {
        Post post = new Post();
        post.setContents(this.contents);
        post.setImageUrl(this.imageUrl);
        post.setCreatedDate(LocalDateTime.now());
        return post;
    }
}
