package cz.osu.student.r19229.rest.exceptions;

public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException(Long threadId, Long postId){
        super("Could not find post with id " + postId + " that belongs to thread with id " + threadId);
    }
}
