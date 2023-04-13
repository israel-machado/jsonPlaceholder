package com.example.jsonplaceholder.services;

import com.example.jsonplaceholder.model.User;
import com.example.jsonplaceholder.model.dto.request.UserRequest;
import com.example.jsonplaceholder.model.dto.response.UserResponse;
import com.example.jsonplaceholder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.jsonplaceholder.converters.UserConverter.convertToUser;

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

    public UserResponse insert(UserRequest userRequest) {
        User user = convertToUser(userRequest);
        user = repository.save(user);
        return new UserResponse(user);
    }

    public UserResponse update(Long id, UserRequest userRequest) {
        User user = convertToUser(userRequest);
        user.setId(id);
        User updatedUser = repository.save(user);
        return new UserResponse(updatedUser);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
