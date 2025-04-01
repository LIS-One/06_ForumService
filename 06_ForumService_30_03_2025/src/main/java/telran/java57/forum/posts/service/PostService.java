package telran.java57.forum.posts.service;

import telran.java57.forum.posts.dto.NewPostDto;
import telran.java57.forum.posts.dto.PostDto;
import telran.java57.forum.posts.dto.UpdatePostDto;

import java.util.List;

public interface PostService {

    PostDto addNewPost(String author, NewPostDto newPostDto);

    PostDto getPostById(String id);

    NewPostDto updatePost(String id, UpdatePostDto updatePostDto);

    PostDto removePost(String id);

    List<PostDto> findPostsByAuthor(String name);
}
