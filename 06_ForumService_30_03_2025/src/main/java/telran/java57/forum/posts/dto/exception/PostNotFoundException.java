package telran.java57.forum.posts.dto.exception;



public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException(String id) {
        super("Post with id " + id + " not found");
    }
}
