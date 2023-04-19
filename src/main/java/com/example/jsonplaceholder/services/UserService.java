package com.example.jsonplaceholder.services;

import com.example.jsonplaceholder.mappers.UserConverter;
import com.example.jsonplaceholder.model.domain.user.UserDomain;
import com.example.jsonplaceholder.model.dto.request.UserRequest;
import com.example.jsonplaceholder.model.dto.response.UserResponse;
import com.example.jsonplaceholder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.jsonplaceholder.mappers.UserConverter.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserResponse> findAllUsers() {
        List<UserDomain> userList = userRepository.findAll();
        return generateUserDomainListToResponseList(userList);
    }

    public UserResponse findUserById(Long id) {
        Optional<UserDomain> user = userRepository.findById(id);
        return user.map(UserConverter::convertUserDomainToUserResponse).orElse(null);
    }

    public UserResponse insertUser(UserRequest userRequest) {
        UserDomain user = convertUserRequestToDomain(userRequest);
        user = userRepository.save(user);
        return convertUserDomainToUserResponse(user);
    }

    public UserResponse updateUser(Long id, UserRequest userRequest) {
        UserDomain user = convertUserRequestToDomain(userRequest);
        user.setId(id);
        UserDomain updatedUser = userRepository.save(user);
        return convertUserDomainToUserResponse(updatedUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
