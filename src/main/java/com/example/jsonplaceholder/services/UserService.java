package com.example.jsonplaceholder.services;

import com.example.jsonplaceholder.model.User;
import com.example.jsonplaceholder.model.dto.request.UserRequest;
import com.example.jsonplaceholder.model.dto.response.UserResponse;
import com.example.jsonplaceholder.model.sup.Address;
import com.example.jsonplaceholder.model.sup.Company;
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

    private User convertToUser(UserRequest userRequest) {
        Address address = new Address();
        address.setStreet(userRequest.getAddressRequest().getStreet());
        address.setSuite(userRequest.getAddressRequest().getSuite());
        address.setCity(userRequest.getAddressRequest().getCity());
        address.setZipcode(userRequest.getAddressRequest().getZipcode());

        Company company = new Company();
        company.setName(userRequest.getCompanyRequest().getName());
        company.setCatchPhrase(userRequest.getCompanyRequest().getCatchPhrase());
        company.setBs(userRequest.getCompanyRequest().getBs());

        User user = new User();
        user.setName(userRequest.getName());
        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        user.setPhone(userRequest.getPhone());
        user.setWebsite(userRequest.getWebsite());
        user.setAddress(address);
        user.setCompany(company);

        return user;
    }
}
