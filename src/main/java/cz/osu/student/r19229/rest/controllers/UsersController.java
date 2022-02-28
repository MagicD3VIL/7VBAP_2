package cz.osu.student.r19229.rest.controllers;

import java.util.List;

import cz.osu.student.r19229.rest.exceptions.*;
import cz.osu.student.r19229.rest.models.Users;
import cz.osu.student.r19229.rest.repositories.UsersRepository;
import org.springframework.web.bind.annotation.*;

@RestController
record UsersController(UsersRepository repository) {

    @GetMapping("/users")
    List<Users> all() {
        return repository.findAll();
    }

    @PostMapping("/users")
    Users newUsers(@RequestBody Users newUser) {
        return repository.save(newUser);
    }

    @GetMapping("/users/{uuid}")
    Users one(@PathVariable Long uuid) {
        return repository.findById(uuid).orElseThrow(() -> new UserNotFoundException(uuid));
    }

    @PutMapping("/users/{uuid}")
    Users replaceUser(@RequestBody Users newUser, @PathVariable Long uuid) {
        return repository.findById(uuid)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setNickname(newUser.getNickname());
                    user.setEmail(newUser.getEmail());
                    return repository.save(user);
                })
                .orElseGet(() -> {
                    return repository.save(newUser);
                });
    }

    @DeleteMapping("/users/{uuid}")
    void deleteUser(@PathVariable long uuid) {
        repository.deleteById(uuid);
    }
}
