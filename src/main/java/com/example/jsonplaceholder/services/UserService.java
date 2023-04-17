package com.example.jsonplaceholder.services;

import com.example.jsonplaceholder.client.JsonPlaceholderClient;
import com.example.jsonplaceholder.converters.UserConverter;
import com.example.jsonplaceholder.model.domain.user.UserDomain;
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
    @Autowired
    private JsonPlaceholderClient jsonPlaceholderClient;

    public List<UserResponse> findAll() {
        List<UserDomain> userList = repository.findAll();
        return generateUserResponseList(userList);
    }

    public UserResponse findById(Long id) {
        Optional<UserDomain> user = repository.findById(id);
        return user.map(UserConverter::convertToUserResponse).orElse(null);
    }

    public UserResponse insert(UserRequest userRequest) {
        UserDomain user = convertToUser(userRequest);
        user = repository.save(user);
        return convertToUserResponse(user);
    }

    public UserResponse update(Long id, UserRequest userRequest) {
        UserDomain user = convertToUser(userRequest);
        user.setId(id);
        UserDomain updatedUser = repository.save(user);
        return convertToUserResponse(updatedUser);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    //API
    //TODO Criar um DTO utility de User para Address/Company/Geo
    public void saveUsersFromApi() {
        List<UserDomain> users = jsonPlaceholderClient.getUsers();
        for (UserDomain user : users) {


            repository.save(user);
        }
    }
}
