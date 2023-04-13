package com.example.jsonplaceholder.services;

import com.example.jsonplaceholder.model.User;
import com.example.jsonplaceholder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = repository.findById(id);
        return user.orElse(null);
    }

    public User insert(User user) {
        return repository.save(user);
    }

    public User update(Long id, User user) {
        User reference = repository.getReferenceById(id);
        updateData(reference, user);
        return repository.save(user);
    }

    private void updateData(User reference, User user) {
        reference.setName(user.getName());
        reference.setEmail((user.getEmail()));
        reference.setUsername(user.getUsername());
        reference.setPhone(user.getPhone());
        reference.setCompany(user.getCompany());
        reference.setWebsite(user.getWebsite());
        reference.setCompany(user.getCompany());
        reference.setAddress(user.getAddress());
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
