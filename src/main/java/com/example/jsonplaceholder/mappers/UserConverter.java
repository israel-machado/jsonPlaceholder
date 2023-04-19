package com.example.jsonplaceholder.mappers;

import com.example.jsonplaceholder.model.domain.user.AddressDomain;
import com.example.jsonplaceholder.model.domain.user.CompanyDomain;
import com.example.jsonplaceholder.model.domain.user.GeoDomain;
import com.example.jsonplaceholder.model.domain.user.UserDomain;
import com.example.jsonplaceholder.model.dto.request.UserRequest;
import com.example.jsonplaceholder.model.dto.response.UserResponse;
import com.example.jsonplaceholder.model.dto.response.sup.AddressResponse;
import com.example.jsonplaceholder.model.dto.response.sup.CompanyResponse;
import com.example.jsonplaceholder.model.placeholder.user.GeoPlaceholder;
import com.example.jsonplaceholder.model.placeholder.user.UserPlaceholder;

import java.util.List;
import java.util.stream.Collectors;

public class UserConverter {

    // User Converters
    public static UserDomain convertUserRequestToDomain(UserRequest userRequest) {

        return UserDomain.builder()
                .id(userRequest.getId())
                .name(userRequest.getName())
                .username(userRequest.getUsername())
                .phone(userRequest.getPhone())
                .website(userRequest.getWebsite())
                .website(userRequest.getWebsite())
                .email(userRequest.getEmail())
                .address(convertAddressDomain(userRequest))
                .company(convertCompanyRequestToDomain(userRequest))
                .build();
    }

    public static UserDomain convertUserPlaceholderToDomain(UserPlaceholder userPlaceholder) {
        return UserDomain.builder()
                .id(userPlaceholder.getId())
                .name(userPlaceholder.getName())
                .email(userPlaceholder.getEmail())
                .username(userPlaceholder.getUsername())
                .website(userPlaceholder.getWebsite())
                .phone(userPlaceholder.getPhone())
                .address(convertAddressPlaceholderToDomain(userPlaceholder))
                .company(convertCompanyPlaceholderToDomain(userPlaceholder))
                .build();
    }

    //UserResponse

    public static UserResponse convertUserDomainToUserResponse(UserDomain user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .username(user.getUsername())
                .email(user.getEmail())
                .phone(user.getPhone())
                .website(user.getWebsite())
                .addressResponse(convertAddressResponse(user))
                .companyResponse(convertCompanyDomainToResponse(user))
                .build();
    }

    public static List<UserResponse> generateUserDomainListToResponseList(List<UserDomain> userList) {
        return userList.stream()
                .map(UserConverter::convertUserDomainToUserResponse)
                .collect(Collectors.toList());
    }

    // Company Converters

    private static CompanyDomain convertCompanyRequestToDomain(UserRequest userRequest) {
        return CompanyDomain.builder()
                .id(userRequest.getCompanyRequest().getId())
                .name(userRequest.getCompanyRequest().getName())
                .bs(userRequest.getCompanyRequest().getBs())
                .catchPhrase(userRequest.getCompanyRequest().getCatchPhrase())
                .build();
    }

    private static CompanyResponse convertCompanyDomainToResponse(UserDomain user) {
        return CompanyResponse.builder()
                .id(user.getCompany().getId())
                .name(user.getCompany().getName())
                .bs(user.getCompany().getBs())
                .catchPhrase(user.getCompany().getCatchPhrase())
                .build();
    }

    private static CompanyDomain convertCompanyPlaceholderToDomain(UserPlaceholder userPlaceholder) {
        return CompanyDomain.builder()
                .name(userPlaceholder.getCompany().getName())
                .bs(userPlaceholder.getCompany().getBs())
                .catchPhrase(userPlaceholder.getCompany().getCatchPhrase())
                .build();
    }

    // Address Converters

    private static AddressDomain convertAddressDomain(UserRequest userRequest) {
        return AddressDomain.builder()
                .id(userRequest.getAddressRequest().getId())
                .city(userRequest.getAddressRequest().getCity())
                .suite(userRequest.getAddressRequest().getSuite())
                .street(userRequest.getAddressRequest().getStreet())
                .zipcode(userRequest.getAddressRequest().getZipcode())
                .geo(userRequest.getAddressRequest().getGeo())
                .build();
    }

    public static AddressDomain convertAddressPlaceholderToDomain(UserPlaceholder userPlaceholder) {
        return AddressDomain.builder()
                .street(userPlaceholder.getAddress().getStreet())
                .suite(userPlaceholder.getAddress().getSuite())
                .city(userPlaceholder.getAddress().getCity())
                .zipcode(userPlaceholder.getAddress().getZipcode())
                .geo(convertGeoDomain(userPlaceholder.getAddress().getGeo()))
                .build();
    }

    private static AddressResponse convertAddressResponse(UserDomain user) {
        return AddressResponse.builder()
                .id(user.getAddress().getId())
                .city(user.getAddress().getCity())
                .suite(user.getAddress().getSuite())
                .street(user.getAddress().getStreet())
                .zipcode(user.getAddress().getZipcode())
                .geo(user.getAddress().getGeo())
                .build();
    }

    // Geo Converters

    private static GeoDomain convertGeoDomain(GeoPlaceholder geoPlaceholder) {
        return GeoDomain.builder()
                .lng(geoPlaceholder.getLng())
                .lat(geoPlaceholder.getLat())
                .build();
    }
}
