package telran.java57.forum.posts.dto;

import lombok.Getter;

import java.util.Set;
@Getter
public class UpdatePostDto {
    String title;
    String content;
    String author;
    Set<String> tags;
}
