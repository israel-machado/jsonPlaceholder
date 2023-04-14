package com.example.jsonplaceholder.services;

import com.example.jsonplaceholder.converters.UserConverter;
import com.example.jsonplaceholder.model.User;
import com.example.jsonplaceholder.model.dto.request.UserRequest;
import com.example.jsonplaceholder.model.dto.response.UserResponse;
import com.example.jsonplaceholder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.jsonplaceholder.converters.UserConverter.*;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserResponse> findAll() {
        List<User> userList = repository.findAll();
        return generateUserResponseList(userList);
    }

    public UserResponse findById(Long id) {
        Optional<User> user = repository.findById(id);
        return user.map(UserConverter::convertToUserResponse).orElse(null);
    }

    public UserResponse insert(UserRequest userRequest) {
        User user = convertToUser(userRequest);
        user = repository.save(user);
        return convertToUserResponse(user);
    }

    public UserResponse update(Long id, UserRequest userRequest) {
        User user = convertToUser(userRequest);
        user.setId(id);
        User updatedUser = repository.save(user);
        return convertToUserResponse(user);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
