package com.example.jsonplaceholder.services;

import com.example.jsonplaceholder.client.JsonPlaceholderClient;
import com.example.jsonplaceholder.converters.UserConverter;
import com.example.jsonplaceholder.model.User;
import com.example.jsonplaceholder.model.dto.request.UserRequest;
import com.example.jsonplaceholder.model.dto.response.UserResponse;
import com.example.jsonplaceholder.model.sup.Address;
import com.example.jsonplaceholder.model.sup.Company;
import com.example.jsonplaceholder.model.sup.Geo;
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

    private JsonPlaceholderClient jsonPlaceholderClient;

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

    //API

    public void saveUsersFromApi() {
        List<User> users = jsonPlaceholderClient.getUsers();
        for (User user : users) {
            Address address = user.getAddress();
            if (address != null) {
                address.setId(user.getId());
                Geo geo = address.getGeo();
                if (geo != null) {
                    geo.setId(user.getId());
                }
            }
            Company company = user.getCompany();
            if (company != null) {
                company.setId(user.getId());
            }
            repository.save(user);
        }
    }
}
