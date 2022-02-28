package cz.osu.student.r19229.rest.views;

import cz.osu.student.r19229.rest.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TagNotFoundView {
    @ResponseBody
    @ExceptionHandler(TagNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String tagNotFoundHandler(TagNotFoundException ex) {
        return ex.getMessage();
    }
}
