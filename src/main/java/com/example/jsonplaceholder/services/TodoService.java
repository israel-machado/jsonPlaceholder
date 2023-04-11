package com.example.jsonplaceholder.services;

import com.example.jsonplaceholder.model.Todo;
import com.example.jsonplaceholder.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public List<Todo> getAll() {
        return repository.findAll();
    }

    public Todo getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Todo save(Todo Todo) {
        return repository.save(Todo);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
