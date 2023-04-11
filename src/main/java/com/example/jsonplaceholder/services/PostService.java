package com.example.jsonplaceholder.services;

import com.example.jsonplaceholder.model.Post;
import com.example.jsonplaceholder.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public List<Post> getAll() {
        return repository.findAll();
    }

    public Post getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Post save(Post Post) {
        return repository.save(Post);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
