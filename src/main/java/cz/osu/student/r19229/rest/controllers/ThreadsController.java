package cz.osu.student.r19229.rest.controllers;

import java.util.List;
import cz.osu.student.r19229.rest.exceptions.*;
import cz.osu.student.r19229.rest.models.Threads;
import cz.osu.student.r19229.rest.repositories.ThreadsRepository;
import org.springframework.web.bind.annotation.*;

@RestController
record ThreadsController(ThreadsRepository repository) {
    @GetMapping("/threads")
    List<Threads> all() {
        return repository.findAll();
    }

    @PostMapping("/threads")
    Threads newThread(@RequestBody Threads newThread) {
        return repository.save(newThread);
    }

    @GetMapping("/threads/{id}")
    Threads one(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ThreadNotFoundException(id));
    }

    @PutMapping("/threads/{id}")
    Threads replaceThread(@RequestBody Threads newThread, @PathVariable Long id) {
        return repository.findById(id)
                .map(thread -> {
                    thread.setName(newThread.getName());
                    thread.setId(newThread.getId());
                    thread.setCreatedBy(newThread.getCreatedBy());
                    return repository.save(thread);
                })
                .orElseGet(() -> {
                    return repository.save(newThread);
                });
    }

    @DeleteMapping("/threads/{id}")
    void deleteThread(@PathVariable long id) {
        repository.deleteById(id);
    }
}
