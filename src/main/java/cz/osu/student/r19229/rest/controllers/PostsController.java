package cz.osu.student.r19229.rest.controllers;

import java.util.List;
import cz.osu.student.r19229.rest.exceptions.*;
import cz.osu.student.r19229.rest.models.Posts;
import cz.osu.student.r19229.rest.repositories.PostsRepository;
import org.springframework.web.bind.annotation.*;

@RestController
record PostsController(PostsRepository repository) {
    @GetMapping("/posts")
    List<Posts> all() {
        return repository.findAll();
    }

    @PostMapping("/threads/{id}")
    Posts newPost(@RequestBody Posts newPost) {
        return repository.save(newPost);
    }

    @GetMapping("/threads/{threadId}/posts")
    List<Posts> byThread(@PathVariable Long threadId) {
        return repository.findAllByThread(threadId);
    }

    @GetMapping("/threads/{threadId}/posts/{postId}")
    Posts one(@PathVariable Long threadId, @PathVariable Long postId) {
        return repository.findByThreadAndId(threadId, postId).orElseThrow(() -> new PostNotFoundException(threadId, postId));
    }

    @PutMapping("/threads/{threadId}/posts/{postId}")
    Posts replacePost(@RequestBody Posts newPost, @PathVariable Long threadId, @PathVariable Long postId) {
        return repository.findByThreadAndId(threadId, postId)
                .map(post -> {
                    post.setThread(newPost.getThread());
                    post.setId(newPost.getId());
                    post.setContent(newPost.getContent());
                    return repository.save(post);
                })
                .orElseGet(() -> {
                    return repository.save(newPost);
                });
    }

    @DeleteMapping("/threads/{threadId}/posts/{postId}")
    void deletePost(@PathVariable Long threadId, @PathVariable Long postId) {
        repository.deleteByThreadAndId(threadId, postId);
    }
}
