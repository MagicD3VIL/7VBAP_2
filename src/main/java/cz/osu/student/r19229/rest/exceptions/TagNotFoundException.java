package cz.osu.student.r19229.rest.exceptions;

public class TagNotFoundException extends RuntimeException {
    public TagNotFoundException(Long id){
        super("Could not find tag with id " + id);
    }
}
