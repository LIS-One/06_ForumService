package telran.java57.forum.posts.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import telran.java57.forum.posts.dto.*;
import telran.java57.forum.posts.service.PostService;

import java.util.Iterator;
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
    @PutMapping("post/{id}/comment/{author}")
    public PostDto addComment(@PathVariable String id, @PathVariable String author, @RequestBody NewCommentDto newCommentDto){
        return postService.addComment(id,author,newCommentDto);
    }

    @PostMapping("/posts/tags}")
    public Iterable<PostDto> findPostsByTags(@RequestBody List<String> tags){
        return postService.findPostsByTags(tags);
    }

    @PostMapping("/posts/period}")
    public Iterable<PostDto> findPostsByPeriod(@RequestBody DatePeriodDto datePeriodDto){
        return postService.findPostsByPeriod(datePeriodDto);
    }
    @PutMapping("/posts/{id}/like")
    public void addLike(@PathVariable String id){
         postService.addLike(id);
    }
}
