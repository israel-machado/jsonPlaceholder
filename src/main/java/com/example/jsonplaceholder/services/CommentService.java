package com.example.jsonplaceholder.services;

import com.example.jsonplaceholder.model.Comment;
import com.example.jsonplaceholder.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository repository;

    public List<Comment> getAll() {
        return repository.findAll();
    }

    public Comment getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Comment save(Comment Comment) {
        return repository.save(Comment);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
