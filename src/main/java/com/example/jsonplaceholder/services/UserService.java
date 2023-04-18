package com.example.jsonplaceholder.services;

import com.example.jsonplaceholder.client.JsonPlaceholderClient;
import com.example.jsonplaceholder.mappers.UserConverter;
import com.example.jsonplaceholder.model.domain.user.UserDomain;
import com.example.jsonplaceholder.model.dto.request.UserRequest;
import com.example.jsonplaceholder.model.dto.response.UserResponse;
import com.example.jsonplaceholder.model.placeholder.user.UserPlaceholder;
import com.example.jsonplaceholder.repository.UserRepository;
import com.example.jsonplaceholder.repository.sup.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.jsonplaceholder.mappers.UserConverter.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private JsonPlaceholderClient jsonPlaceholderClient;

    // User

    public List<UserResponse> findAllUsers() {
        List<UserDomain> userList = userRepository.findAll();
        return generateUserResponseList(userList);
    }

    public UserResponse findUserById(Long id) {
        Optional<UserDomain> user = userRepository.findById(id);
        return user.map(UserConverter::convertToUserResponse).orElse(null);
    }

    public UserResponse insertUser(UserRequest userRequest) {
        UserDomain user = convertRequestToDomain(userRequest);
        user = userRepository.save(user);
        return convertToUserResponse(user);
    }

    public UserResponse updateUser(Long id, UserRequest userRequest) {
        UserDomain user = convertRequestToDomain(userRequest);
        user.setId(id);
        UserDomain updatedUser = userRepository.save(user);
        return convertToUserResponse(updatedUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // API

    public void saveUsersFromApi() {
        List<UserPlaceholder> usersPlaceholders = jsonPlaceholderClient.getUsers();
        for (UserPlaceholder user : usersPlaceholders) {
            UserDomain userDomain = convertPlaceholderToDomain(user);
            userRepository.save(userDomain);
        }
    }
}
