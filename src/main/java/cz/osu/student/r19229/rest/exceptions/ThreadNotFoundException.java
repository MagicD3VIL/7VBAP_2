package cz.osu.student.r19229.rest.exceptions;

public class ThreadNotFoundException extends RuntimeException {
    public ThreadNotFoundException(Long uuid){
        super("Could not find thread " + uuid);
    }
}
