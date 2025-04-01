package telran.java57.forum.posts.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import telran.java57.forum.posts.dto.NewPostDto;
import telran.java57.forum.posts.dto.PostDto;
import telran.java57.forum.posts.dto.UpdatePostDto;
import telran.java57.forum.posts.service.PostService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/forum")
public class PostController {
     final PostService postService;
    @PostMapping("/post/{author}")
    public PostDto addNewPost(@PathVariable String author, @RequestBody NewPostDto newPostDto){
        return postService.addNewPost(author,newPostDto);
    }

    @GetMapping("/post/{postid}")
    public PostDto getPostById(@PathVariable String postid){
        return postService.getPostById(postid);
    }
    @PutMapping("/post/{postid}")
    public NewPostDto updatePost(@PathVariable String postid,@RequestBody UpdatePostDto updatePostDto){
        return postService.updatePost(postid,updatePostDto);
    }
    @DeleteMapping("/post/{postid}")
    public PostDto removePost(@PathVariable String postid){
        return postService.removePost(postid);
    }
    @GetMapping("/posts/author/{name}")
    public List<PostDto> findPostsByAuthor(@PathVariable String name){
        return postService.findPostsByAuthor(name);
    }
}
