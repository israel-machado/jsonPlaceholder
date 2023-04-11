package com.example.jsonplaceholder.controller;

import com.example.jsonplaceholder.model.Post;
import com.example.jsonplaceholder.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService service;

    @GetMapping
    public List<Post> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Post getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Post create(@RequestBody Post post) {
        return service.save(post);
    }

    @PutMapping("/{id}")
    public Post update(@PathVariable Long id, @RequestBody Post post) {
        post.setId(id);
        return service.save(post);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
