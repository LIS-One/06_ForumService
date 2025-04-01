package telran.java57.forum.posts.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import telran.java57.forum.posts.dto.exception.PostNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<String> handlePostNotFound(PostNotFoundException ex){
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}

