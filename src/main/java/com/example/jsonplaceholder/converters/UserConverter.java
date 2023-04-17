package com.example.jsonplaceholder.converters;

import com.example.jsonplaceholder.model.domain.user.UserDomain;
import com.example.jsonplaceholder.model.dto.request.UserRequest;
import com.example.jsonplaceholder.model.dto.response.UserResponse;
import com.example.jsonplaceholder.model.dto.response.sup.AddressResponse;
import com.example.jsonplaceholder.model.dto.response.sup.CompanyResponse;
import com.example.jsonplaceholder.model.domain.user.AddressDomain;
import com.example.jsonplaceholder.model.domain.user.CompanyDomain;

import java.util.List;
import java.util.stream.Collectors;

public class UserConverter {

    public static UserDomain convertToUser(UserRequest userRequest) {

        return UserDomain.builder()
                .id(userRequest.getId())
                .name(userRequest.getName())
                .username(userRequest.getUsername())
                .phone(userRequest.getPhone())
                .website(userRequest.getWebsite())
                .website(userRequest.getWebsite())
                .email(userRequest.getEmail())
                .address(AddressDomain.builder()
                        .id(userRequest.getAddressRequest().getId())
                        .city(userRequest.getAddressRequest().getCity())
                        .suite(userRequest.getAddressRequest().getSuite())
                        .street(userRequest.getAddressRequest().getStreet())
                        .zipcode(userRequest.getAddressRequest().getZipcode())
                        .geo(userRequest.getAddressRequest().getGeo())
                        .build())
                .company(CompanyDomain.builder()
                        .id(userRequest.getCompanyRequest().getId())
                        .name(userRequest.getCompanyRequest().getName())
                        .bs(userRequest.getCompanyRequest().getBs())
                        .catchPhrase(userRequest.getCompanyRequest().getCatchPhrase())
                        .build())
                .build();
    }

    public static UserResponse convertToUserResponse(UserDomain user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .username(user.getUsername())
                .email(user.getEmail())
                .phone(user.getPhone())
                .website(user.getWebsite())
                .addressResponse(AddressResponse.builder()
                        .id(user.getAddress().getId())
                        .city(user.getAddress().getCity())
                        .suite(user.getAddress().getSuite())
                        .street(user.getAddress().getStreet())
                        .zipcode(user.getAddress().getZipcode())
                        .geo(user.getAddress().getGeo())
                        .build())
                .companyResponse(CompanyResponse.builder()
                        .id(user.getCompany().getId())
                        .name(user.getCompany().getName())
                        .bs(user.getCompany().getBs())
                        .catchPhrase(user.getCompany().getCatchPhrase())
                        .build())
                .build();
    }

    public static List<UserResponse> generateUserResponseList(List<UserDomain> userList) {
        return userList.stream()
                .map(UserConverter::convertToUserResponse)
                .collect(Collectors.toList());
    }
}
