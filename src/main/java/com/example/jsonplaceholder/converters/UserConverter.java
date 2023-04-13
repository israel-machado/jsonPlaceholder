package com.example.jsonplaceholder.converters;

import com.example.jsonplaceholder.model.User;
import com.example.jsonplaceholder.model.dto.request.UserRequest;
import com.example.jsonplaceholder.model.sup.Address;
import com.example.jsonplaceholder.model.sup.Company;

public class UserConverter {

    public static User convertToUser(UserRequest userRequest) {
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
