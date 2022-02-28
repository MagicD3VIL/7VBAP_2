package cz.osu.student.r19229.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestAPI {

    private static final Logger log = LoggerFactory.getLogger(RestAPI.class);

    public static void main(String... args) {
        SpringApplication.run(RestAPI.class, args);
    }

}
