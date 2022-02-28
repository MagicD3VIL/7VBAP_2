package cz.osu.student.r19229.rest.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long uuid){
        super("Could not find user " + uuid);
    }
}
