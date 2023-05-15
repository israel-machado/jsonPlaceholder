package com.example.jsonplaceholder.services;

import com.example.jsonplaceholder.mappers.UserConverter;
import com.example.jsonplaceholder.model.domain.user.UserDomain;
import com.example.jsonplaceholder.model.dto.request.UserRequest;
import com.example.jsonplaceholder.model.dto.response.UserResponse;
import com.example.jsonplaceholder.repository.UserRepository;
import com.example.jsonplaceholder.services.exceptions.DatabaseException;
import com.example.jsonplaceholder.services.exceptions.InvalidParameterException;
import com.example.jsonplaceholder.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return user.map(UserConverter::convertUserDomainToUserResponse)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    public UserResponse insertUser(UserRequest userRequest) {
        if (userRequest == null) {
            throw new InvalidParameterException("User request cannot be null");
        }
        UserDomain user = convertUserRequestToDomain(userRequest);
        user = userRepository.save(user);
        return convertUserDomainToUserResponse(user);
    }

    public UserResponse updateUser(Long id, UserRequest userRequest) {
        try {
            if (userRequest == null) {
                throw new InvalidParameterException("User request cannot be null");
            }
            UserDomain user = convertUserRequestToDomain(userRequest);
            user.setId(id);
            UserDomain updatedUser = userRepository.save(user);
            return convertUserDomainToUserResponse(updatedUser);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
    }

    public void deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Error deleting user with id: " + id + " - " + e.getMessage());
        }
    }
}
