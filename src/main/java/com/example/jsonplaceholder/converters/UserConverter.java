package com.example.jsonplaceholder.converters;

import com.example.jsonplaceholder.model.User;
import com.example.jsonplaceholder.model.dto.request.UserRequest;
import com.example.jsonplaceholder.model.sup.Address;
import com.example.jsonplaceholder.model.sup.Company;

public class UserConverter {

    public static User convertToUser(UserRequest userRequest) {

        return User.builder()
                .id(userRequest.getId())
                .name(userRequest.getName())
                .username(userRequest.getUsername())
                .phone(userRequest.getPhone())
                .website(userRequest.getWebsite())
                .website(userRequest.getWebsite())
                .email(userRequest.getEmail())
                .address(Address.builder()
                        .id(userRequest.getAddressRequest().getId())
                        .city(userRequest.getAddressRequest().getCity())
                        .suite(userRequest.getAddressRequest().getSuite())
                        .street(userRequest.getAddressRequest().getStreet())
                        .zipcode(userRequest.getAddressRequest().getZipcode())
                        .geo(userRequest.getAddressRequest().getGeo())
                        .build())
                .company(Company.builder()
                        .id(userRequest.getCompanyRequest().getId())
                        .name(userRequest.getCompanyRequest().getName())
                        .bs(userRequest.getCompanyRequest().getBs())
                        .catchPhrase(userRequest.getCompanyRequest().getCatchPhrase())
                        .build())
                .build();
    }
}
