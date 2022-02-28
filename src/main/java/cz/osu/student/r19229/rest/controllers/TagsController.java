package cz.osu.student.r19229.rest.controllers;

import cz.osu.student.r19229.rest.exceptions.TagNotFoundException;
import cz.osu.student.r19229.rest.models.Tags;
import cz.osu.student.r19229.rest.repositories.TagsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
record TagsController(TagsRepository repository) {
    @GetMapping("/tags")
    List<Tags> all() {
        return repository.findAll();
    }

    @PostMapping("/tags")
    Tags newTag(@RequestBody Tags newTag) {
        return repository.save(newTag);
    }

    @GetMapping("/tags/{id}")
    Tags one(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new TagNotFoundException(id));
    }

    @PutMapping("/tags/{id}")
    Tags replaceTag(@RequestBody Tags newTag, @PathVariable Long id) {
        return repository.findById(id)
                .map(tag -> {
                    tag.setId(newTag.getId());
                    tag.setName(newTag.getName());
                    return repository.save(tag);
                })
                .orElseGet(() -> {
                    return repository.save(newTag);
                });
    }

    @DeleteMapping("/tags/{id}")
    void deleteTag(@PathVariable long id) {
        repository.deleteById(id);
    }
}
