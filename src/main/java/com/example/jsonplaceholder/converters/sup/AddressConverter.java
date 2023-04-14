package com.example.jsonplaceholder.converters.sup;

import com.example.jsonplaceholder.model.dto.request.sup.AddressRequest;
import com.example.jsonplaceholder.model.dto.response.sup.AddressResponse;
import com.example.jsonplaceholder.model.sup.Address;

import java.util.List;
import java.util.stream.Collectors;

public class AddressConverter {

    public static Address convertToAddress(AddressRequest addressRequest) {
        return Address.builder()
                .id(addressRequest.getId())
                .street(addressRequest.getStreet())
                .zipcode(addressRequest.getZipcode())
                .city(addressRequest.getCity())
                .suite(addressRequest.getSuite())
                .geo(addressRequest.getGeo())
                .build();
    }

    public static AddressResponse convertToAddressResponse(Address address) {
        return AddressResponse.builder()
                .id(address.getId())
                .street(address.getStreet())
                .zipcode(address.getZipcode())
                .city(address.getCity())
                .suite(address.getSuite())
                .geo(address.getGeo())
                .build();
    }

    public static List<AddressResponse> generateAddressResponseList(List<Address> AddressList) {
        return AddressList.stream()
                .map(AddressConverter::convertToAddressResponse)
                .collect(Collectors.toList());
    }
}