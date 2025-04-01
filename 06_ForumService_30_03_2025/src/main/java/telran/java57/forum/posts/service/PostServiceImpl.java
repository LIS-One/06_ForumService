package telran.java57.forum.posts.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import telran.java57.forum.posts.dao.PostRepository;
import telran.java57.forum.posts.dto.NewPostDto;
import telran.java57.forum.posts.dto.PostDto;
import telran.java57.forum.posts.dto.UpdatePostDto;
import telran.java57.forum.posts.dto.exception.PostNotFoundException;
import telran.java57.forum.posts.model.Post;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    final PostRepository postRepository;
    final ModelMapper modelMapper;

    @Override
    public PostDto addNewPost(String author, NewPostDto newPostDto) {
        Post post = new Post(newPostDto.getTitle(), newPostDto.getContent(), author, newPostDto.getTags());
        post = postRepository.save(post);
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public PostDto getPostById(String id) {
        Post post = postRepository.findById(id).orElseThrow(()-> new PostNotFoundException(id));
        return modelMapper.map(post,PostDto.class);
    }

    @Override
    public NewPostDto updatePost(String id, UpdatePostDto updatePostDto) {
        Post post = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
        if (updatePostDto.getTitle() != null) {
            post.setTitle(updatePostDto.getTitle());
        }
        if (updatePostDto.getContent() != null) {
            post.setContent(updatePostDto.getContent());
        }
        if (updatePostDto.getAuthor() != null) {
            post.setAuthor(updatePostDto.getAuthor());
        }
        if (updatePostDto.getTags() != null) {
            updatePostDto.getTags().forEach(post::addTag);
        }
        postRepository.save(post);
        return modelMapper.map(post,NewPostDto.class);
    }

    @Override
    public PostDto removePost(String id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
        postRepository.delete(post);
        return modelMapper.map(post,PostDto.class);
    }

    @Override
    public List<PostDto> findPostsByAuthor(String name) {

        return postRepository.findAll().stream()
                .filter(post->name.equalsIgnoreCase(post.getAuthor()))
                .map(post->modelMapper.map(post,PostDto.class))
                .toList();
    }

}



