package cz.osu.student.r19229.rest.controllers;

import java.util.List;
import cz.osu.student.r19229.rest.models.Credentials;
import cz.osu.student.r19229.rest.repositories.CredentialsRepository;
import cz.osu.student.r19229.rest.exceptions.*;
import org.springframework.web.bind.annotation.*;

@RestController
record CredentialsController(CredentialsRepository repository) {
    @GetMapping("/credentials")
    List<Credentials> all() {
        return repository.findAll();
    }

    @PostMapping("/credentials")
    Credentials newCredentials(@RequestBody Credentials newCredentials) {
        return repository.save(newCredentials);
    }

    @GetMapping("/credentials/{uuid}")
    Credentials one(@PathVariable Long uuid) {
        return repository.findById(uuid).orElseThrow(() -> new ThreadNotFoundException(uuid));
    }

    @PutMapping("/credentials/{uuid}")
    Credentials replaceCredentials(@RequestBody Credentials newCredentials, @PathVariable Long uuid) {
        return repository.findById(uuid)
                .map(credentials -> {
                    credentials.setUserUuid(newCredentials.getUserUuid());
                    credentials.setPassword(newCredentials.getPassword());
                    return repository.save(credentials);
                })
                .orElseGet(() -> {
                    return repository.save(newCredentials);
                });
    }

    @DeleteMapping("/credentials/{uuid}")
    void deleteCredentials(@PathVariable long uuid) {
        repository.deleteById(uuid);
    }
}
