package com.example.jsonplaceholder.services;

import com.example.jsonplaceholder.model.User;
import com.example.jsonplaceholder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> getAll() {
        return repository.findAll();
    }

    public User getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public User save(User User) {
        return repository.save(User);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
