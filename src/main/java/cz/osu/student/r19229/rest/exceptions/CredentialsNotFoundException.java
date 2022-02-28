package cz.osu.student.r19229.rest.exceptions;

public class CredentialsNotFoundException extends RuntimeException {
    public CredentialsNotFoundException(Long uuid){
        super("Could not find credentials for user with uuid " + uuid);
    }
}
