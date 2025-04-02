package telran.java57.forum.posts.service;

import telran.java57.forum.posts.dto.*;

import java.util.List;

public interface PostService {

    PostDto addNewPost(String author, NewPostDto newPostDto);

    PostDto getPostById(String id);

    NewPostDto updatePost(String id, UpdatePostDto updatePostDto);

    PostDto removePost(String id);

    List<PostDto> findPostsByAuthor(String name);

    PostDto addComment(String id, String author, NewCommentDto newCommentDto);

    Iterable<PostDto> findPostsByTags(List<String> tags);

    Iterable<PostDto> findPostsByPeriod(DatePeriodDto datePeriodDto);

    void addLike(String id);
}
